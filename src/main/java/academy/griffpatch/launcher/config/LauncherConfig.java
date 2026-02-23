package academy.griffpatch.launcher.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Persists launcher settings (e.g. the last-used username) across sessions.
 *
 * <p>Configuration is stored in a Java {@link Properties} file under the
 * user's home directory at {@code ~/.ga-launcher/config.properties}.
 * All I/O errors are silently swallowed so that a missing or unreadable
 * config file never prevents the launcher from starting.
 */
public class LauncherConfig {

    private static final String CONFIG_DIR = System.getProperty("user.home") + "/.ga-launcher";
    private static final String CONFIG_FILE = CONFIG_DIR + "/config.properties";
    private static final String KEY_USERNAME = "username";

    private final Properties properties = new Properties();

    private LauncherConfig() {}

    /**
     * Loads the configuration from disk.
     *
     * <p>If the file does not exist or cannot be read, an empty configuration
     * is returned instead of throwing an exception.
     *
     * @return a {@code LauncherConfig} instance populated from disk (or empty)
     */
    public static LauncherConfig load() {
        LauncherConfig config = new LauncherConfig();
        File file = new File(CONFIG_FILE);
        if (file.exists()) {
            try (InputStream in = new FileInputStream(file)) {
                config.properties.load(in);
            } catch (IOException ignored) {
                // Return empty config if the file cannot be read.
            }
        }
        return config;
    }

    /**
     * Returns the saved username, or an empty string if none is saved.
     *
     * @return the saved username
     */
    public String getUsername() {
        return properties.getProperty(KEY_USERNAME, "");
    }

    /**
     * Sets the username to be persisted on the next {@link #save()} call.
     *
     * @param username the username to store
     */
    public void setUsername(String username) {
        properties.setProperty(KEY_USERNAME, username);
    }

    /**
     * Writes the current configuration to disk.
     *
     * <p>Creates the config directory if it does not already exist.
     * I/O errors are silently swallowed.
     */
    public void save() {
        try {
            Files.createDirectories(Paths.get(CONFIG_DIR));
            try (OutputStream out = new FileOutputStream(CONFIG_FILE)) {
                properties.store(out, "GA Launcher Config");
            }
        } catch (IOException ignored) {
            // Best-effort save; failure does not affect the launch flow.
        }
    }
}
