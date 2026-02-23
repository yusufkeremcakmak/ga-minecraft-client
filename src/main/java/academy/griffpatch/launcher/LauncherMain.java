package academy.griffpatch.launcher;

/**
 * Application entry point.
 *
 * <p>A separate non-JavaFX main class is required so the JAR can be launched
 * without placing javafx modules on the class-path explicitly (the JavaFX
 * module system loads them from inside {@link LauncherApp}).
 */
public class LauncherMain {

    public static void main(String[] args) {
        LauncherApp.launch(LauncherApp.class, args);
    }
}
