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

    /**
     * Placeholder authentication step.
     *
     * <p>Always returns {@code true}. Real authentication against the
     * membership API will be implemented in a future phase.
     *
     * @param username the username to authenticate
     * @return {@code true} (placeholder — authentication not yet implemented)
     */
    public boolean authenticate(String username) {
        // Placeholder: real authentication against membership API to be added in a future phase.
        return true;
    }

    /**
     * Placeholder networking preparation step.
     *
     * <p>Does nothing yet. Server connection setup will be implemented in a
     * future phase.
     */
    public void prepareNetworking() {
        // Placeholder: server connection setup to be added in a future phase.
    }
}
