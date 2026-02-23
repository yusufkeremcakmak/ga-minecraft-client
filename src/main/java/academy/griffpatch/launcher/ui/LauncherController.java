package academy.griffpatch.launcher.ui;

import academy.griffpatch.launcher.service.LauncherService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the main launcher window.
 *
 * <p>Responsible solely for UI interactions: reading user input, updating
 * displayed text, and enabling/disabling controls. All business logic is
 * delegated to {@link LauncherService}.
 */
public class LauncherController {

    @FXML
    private TextField usernameField;

    @FXML
    private Button launchButton;

    @FXML
    private Label statusLabel;

    private final LauncherService launcherService = new LauncherService();

    @FXML
    private void handleLaunch() {
        String username = usernameField.getText().trim();

        if (!launcherService.isUsernameValid(username)) {
            statusLabel.setText("Please enter a username.");
            return;
        }

        // TODO (Phase 2): authenticate username against membership API
        statusLabel.setText(launcherService.getLaunchStatusMessage(username));
        launchButton.setDisable(true);
    }
}
