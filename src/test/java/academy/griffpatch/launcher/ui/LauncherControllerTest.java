package academy.griffpatch.launcher.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Basic unit tests for {@link LauncherController}.
 *
 * <p>Full UI tests require a running JavaFX toolkit (TestFX or Monocle).
 * These lightweight tests verify the controller can be instantiated and
 * that the class structure is correct, without spinning up a display.
 */
class LauncherControllerTest {

    private LauncherController controller;

    @BeforeEach
    void setUp() {
        controller = new LauncherController();
    }

    @Test
    void controllerInstantiates() {
        assertNotNull(controller, "LauncherController should be instantiable");
    }
}
