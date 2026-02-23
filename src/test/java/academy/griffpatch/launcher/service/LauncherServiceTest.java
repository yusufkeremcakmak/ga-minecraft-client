package academy.griffpatch.launcher.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link LauncherService}.
 *
 * <p>These tests run entirely without a JavaFX toolkit, verifying business
 * logic in complete isolation from the UI layer.
 */
class LauncherServiceTest {

    private LauncherService service;

    @BeforeEach
    void setUp() {
        service = new LauncherService();
    }

    @Test
    void serviceInstantiates() {
        assertNotNull(service, "LauncherService should be instantiable");
    }

    @Test
    void isUsernameValid_nullReturnsFalse() {
        assertFalse(service.isUsernameValid(null), "null username should be invalid");
    }

    @Test
    void isUsernameValid_emptyReturnsFalse() {
        assertFalse(service.isUsernameValid(""), "empty username should be invalid");
    }

    @Test
    void isUsernameValid_whitespaceOnlyReturnsFalse() {
        assertFalse(service.isUsernameValid("   "), "whitespace-only username should be invalid");
    }

    @Test
    void isUsernameValid_validNameReturnsTrue() {
        assertTrue(service.isUsernameValid("Steve"), "letters-only username should be valid");
    }

    @Test
    void isUsernameValid_tooShortReturnsFalse() {
        assertFalse(service.isUsernameValid("ab"), "username shorter than 3 chars should be invalid");
    }

    @Test
    void isUsernameValid_tooLongReturnsFalse() {
        assertFalse(service.isUsernameValid("a".repeat(17)), "username longer than 16 chars should be invalid");
    }

    @Test
    void isUsernameValid_invalidCharsReturnsFalse() {
        assertFalse(service.isUsernameValid("bad username"), "username with spaces should be invalid");
    }

    @Test
    void isUsernameValid_underscoreAndNumbersValid() {
        assertTrue(service.isUsernameValid("Steve_42"), "username with letters, numbers, underscores should be valid");
    }

    @Test
    void getValidationErrorMessage_validUsernameReturnsNull() {
        assertNull(service.getValidationErrorMessage("Steve"), "valid username should return null error message");
    }

    @Test
    void getValidationErrorMessage_invalidUsernameReturnsMessage() {
        assertNotNull(service.getValidationErrorMessage("ab"), "too-short username should return an error message");
    }

    @Test
    void getLaunchStatusMessage_containsUsername() {
        String message = service.getLaunchStatusMessage("Steve");
        assertTrue(message.contains("Steve"), "launch message should contain the username");
    }

    @Test
    void getLaunchStatusMessage_format() {
        assertEquals("Welcome, Alex! Launching...", service.getLaunchStatusMessage("Alex"),
                "launch message should match expected format");
    }
}
