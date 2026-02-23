package academy.griffpatch.launcher.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the main launcher window.
 *
 * <p>Handles user interactions such as entering a username and clicking
 * the launch button. Networking and authentication logic will be wired
 * in here during later phases.
 */
public class LauncherController {

    @FXML
    private TextField usernameField;

    @FXML
    private Button launchButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleLaunch() {
        String username = usernameField.getText().trim();

        if (username.isEmpty()) {
            statusLabel.setText("Please enter a username.");
            return;
        }

        // TODO (Phase 2): authenticate username against membership API
        statusLabel.setText("Welcome, " + username + "! Launching...");
        launchButton.setDisable(true);
    }
}
