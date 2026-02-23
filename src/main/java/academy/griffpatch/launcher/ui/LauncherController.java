package academy.griffpatch.launcher.ui;

import academy.griffpatch.launcher.config.LauncherConfig;
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
    private LauncherConfig config;

    /** Called by the JavaFX runtime after all {@code @FXML} fields are injected. */
    @FXML
    private void initialize() {
        config = LauncherConfig.load();
        String savedUsername = config.getUsername();
        if (!savedUsername.isEmpty()) {
            usernameField.setText(savedUsername);
        }
    }

    @FXML
    private void handleLaunch() {
        String username = usernameField.getText().trim();

        // Step 1: Validate the username.
        if (!launcherService.isUsernameValid(username)) {
            statusLabel.setText("Please enter a username.");
            return;
        }

        // Step 2: Save the username to config.
        config.setUsername(username);
        config.save();
        statusLabel.setText("Configuration saved.");

        // Step 3: Status update — authenticating.
        statusLabel.setText("Authenticating...");

        // Step 4: Placeholder authentication (real auth to be added in a future phase).
        launcherService.authenticate(username);

        // Step 5: Prepare for future networking.
        launcherService.prepareNetworking();

        statusLabel.setText(launcherService.getLaunchStatusMessage(username));
        launchButton.setDisable(true);
    }
}
