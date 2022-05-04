package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
public class ApplicationLauncher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationLauncher.class.getResource("/MySqlProject.fxml"));
        System.out.println(fxmlLoader.getLocation());
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Project database");
        stage.sizeToScene();
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
