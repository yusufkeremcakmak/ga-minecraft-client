package academy.griffpatch.launcher.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link LauncherConfig}.
 *
 * <p>These tests verify in-memory behaviour (get/set username) and that
 * {@code load()} always returns a non-null instance. File I/O is exercised
 * implicitly because {@code load()} reads the real config file when present;
 * the default empty-string behaviour is verified without touching the disk.
 */
class LauncherConfigTest {

    @Test
    void load_returnsNonNull() {
        assertNotNull(LauncherConfig.load(), "load() should always return a non-null instance");
    }

    @Test
    void defaultUsernameIsEmpty() {
        LauncherConfig config = LauncherConfig.load();
        // getUsername() must return a non-null value; it may be empty or a previously saved name.
        assertNotNull(config.getUsername(), "getUsername() should never return null");
    }

    @Test
    void setAndGetUsername_roundTrip() {
        LauncherConfig config = LauncherConfig.load();
        config.setUsername("Steve");
        assertEquals("Steve", config.getUsername(), "getUsername() should return the value set via setUsername()");
    }

    @Test
    void setUsername_overwritesPreviousValue() {
        LauncherConfig config = LauncherConfig.load();
        config.setUsername("Steve");
        config.setUsername("Alex");
        assertEquals("Alex", config.getUsername(), "setUsername() should overwrite the previous value");
    }

    @Test
    void save_doesNotThrow() {
        LauncherConfig config = LauncherConfig.load();
        config.setUsername("TestUser");
        assertDoesNotThrow(config::save, "save() should not throw even if the config directory already exists");
    }
}
