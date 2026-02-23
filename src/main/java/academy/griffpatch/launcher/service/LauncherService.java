package academy.griffpatch.launcher.service;

/**
 * Service class that encapsulates all non-UI business logic for the launcher.
 *
 * <p>Keeping this logic separate from {@code LauncherController} makes each
 * responsibility testable in isolation and provides clear extension points for
 * future authentication and networking features.
 */
public class LauncherService {

    /**
     * Determines whether the supplied username is valid.
     *
     * <p>A username is considered valid when it is non-null and contains at
     * least one non-whitespace character.
     *
     * @param username the username to validate
     * @return {@code true} if the username is valid; {@code false} otherwise
     */
    public boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty();
    }

    /**
     * Builds the status message shown to the user when a launch is triggered.
     *
     * @param username the validated username
     * @return a human-readable launch status message
     */
    public String getLaunchStatusMessage(String username) {
        return "Welcome, " + username + "! Launching...";
    }
}
