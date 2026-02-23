package academy.griffpatch.launcher.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link UsernameValidator}.
 */
class UsernameValidatorTest {

    private UsernameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UsernameValidator();
    }

    // --- isValid ---

    @Test
    void isValid_nullReturnsFalse() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void isValid_emptyReturnsFalse() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void isValid_tooShortReturnsFalse() {
        assertFalse(validator.isValid("ab"));
    }

    @Test
    void isValid_tooLongReturnsFalse() {
        assertFalse(validator.isValid("a".repeat(UsernameValidator.MAX_LENGTH + 1)));
    }

    @Test
    void isValid_invalidCharsReturnsFalse() {
        assertFalse(validator.isValid("user name"));
        assertFalse(validator.isValid("user-name"));
        assertFalse(validator.isValid("user@name"));
    }

    @Test
    void isValid_minimumLengthReturnsTrue() {
        assertTrue(validator.isValid("abc"));
    }

    @Test
    void isValid_maximumLengthReturnsTrue() {
        assertTrue(validator.isValid("a".repeat(UsernameValidator.MAX_LENGTH)));
    }

    @Test
    void isValid_lettersOnlyReturnsTrue() {
        assertTrue(validator.isValid("Steve"));
    }

    @Test
    void isValid_numbersOnlyReturnsTrue() {
        assertTrue(validator.isValid("123"));
    }

    @Test
    void isValid_underscoresReturnsTrue() {
        assertTrue(validator.isValid("my_username"));
    }

    @Test
    void isValid_mixedValidCharsReturnsTrue() {
        assertTrue(validator.isValid("Steve_42"));
    }

    // --- getErrorMessage ---

    @Test
    void getErrorMessage_nullReturnsEmptyError() {
        assertNotNull(validator.getErrorMessage(null));
        assertTrue(validator.getErrorMessage(null).toLowerCase().contains("empty"));
    }

    @Test
    void getErrorMessage_emptyReturnsEmptyError() {
        assertNotNull(validator.getErrorMessage(""));
        assertTrue(validator.getErrorMessage("").toLowerCase().contains("empty"));
    }

    @Test
    void getErrorMessage_tooShortReturnsLengthError() {
        String message = validator.getErrorMessage("ab");
        assertNotNull(message);
        assertTrue(message.contains(String.valueOf(UsernameValidator.MIN_LENGTH)));
    }

    @Test
    void getErrorMessage_tooLongReturnsLengthError() {
        String message = validator.getErrorMessage("a".repeat(UsernameValidator.MAX_LENGTH + 1));
        assertNotNull(message);
        assertTrue(message.contains(String.valueOf(UsernameValidator.MAX_LENGTH)));
    }

    @Test
    void getErrorMessage_invalidCharsReturnsCharError() {
        String message = validator.getErrorMessage("bad username!");
        assertNotNull(message);
        assertTrue(message.toLowerCase().contains("letters"));
    }

    @Test
    void getErrorMessage_validReturnsNull() {
        assertNull(validator.getErrorMessage("Steve_42"));
    }
}
