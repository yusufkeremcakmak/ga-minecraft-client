package academy.griffpatch.launcher.service;

import academy.griffpatch.launcher.validation.UsernameValidator;

/**
 * Service class that encapsulates all non-UI business logic for the launcher.
 *
 * <p>Keeping this logic separate from {@code LauncherController} makes each
 * responsibility testable in isolation and provides clear extension points for
 * future authentication and networking features.
 */
public class LauncherService {

    private final UsernameValidator usernameValidator = new UsernameValidator();

    /**
     * Determines whether the supplied username is valid.
     *
     * <p>Delegates to {@link UsernameValidator}: only letters, numbers, and
     * underscores are accepted, and the length must be between
     * {@value UsernameValidator#MIN_LENGTH} and {@value UsernameValidator#MAX_LENGTH}.
     *
     * @param username the username to validate
     * @return {@code true} if the username is valid; {@code false} otherwise
     */
    public boolean isUsernameValid(String username) {
        return usernameValidator.isValid(username);
    }

    /**
     * Returns a human-readable validation error message for the given username,
     * or {@code null} if the username is valid.
     *
     * @param username the username to validate
     * @return an error message, or {@code null} if the username is valid
     */
    public String getValidationErrorMessage(String username) {
        return usernameValidator.getErrorMessage(username);
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
