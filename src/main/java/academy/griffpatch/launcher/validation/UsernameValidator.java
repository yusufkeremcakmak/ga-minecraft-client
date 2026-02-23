package academy.griffpatch.launcher.validation;

import java.util.regex.Pattern;

/**
 * Reusable validator for Minecraft usernames.
 *
 * <p>Enforces the following rules:
 * <ul>
 *   <li>Only letters, numbers, and underscores are allowed.</li>
 *   <li>Length must be between {@value #MIN_LENGTH} and {@value #MAX_LENGTH} characters.</li>
 * </ul>
 */
public class UsernameValidator {

    static final int MIN_LENGTH = 3;
    static final int MAX_LENGTH = 16;

    private static final Pattern VALID_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");

    /**
     * Returns {@code true} if the username satisfies all validation rules.
     *
     * @param username the username to validate
     * @return {@code true} if valid; {@code false} otherwise
     */
    public boolean isValid(String username) {
        return getErrorMessage(username) == null;
    }

    /**
     * Returns a human-readable error message describing why the username is
     * invalid, or {@code null} if the username is valid.
     *
     * @param username the username to validate
     * @return an error message, or {@code null} if the username is valid
     */
    public String getErrorMessage(String username) {
        if (username == null || username.isEmpty()) {
            return "Username cannot be empty.";
        }
        if (username.length() < MIN_LENGTH) {
            return "Username must be at least " + MIN_LENGTH + " characters.";
        }
        if (username.length() > MAX_LENGTH) {
            return "Username must be no more than " + MAX_LENGTH + " characters.";
        }
        if (!VALID_PATTERN.matcher(username).matches()) {
            return "Username may only contain letters, numbers, and underscores.";
        }
        return null;
    }
}
