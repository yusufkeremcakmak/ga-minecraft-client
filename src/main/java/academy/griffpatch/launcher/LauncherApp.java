package academy.griffpatch.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX application for the Griffpatch Academy Minecraft Launcher.
 *
 * <p>Bootstraps the primary stage and loads the launcher FXML view.
 * Networking and authentication hooks can be added here in later phases.
 */
public class LauncherApp extends Application {

    private static final String TITLE = "Griffpatch Academy Launcher";
    private static final int WIDTH = 480;
    private static final int HEIGHT = 320;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/academy/griffpatch/launcher/ui/launcher.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
