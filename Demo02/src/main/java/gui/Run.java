package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Run extends Application {

    /**
     * Creates a new instance of stage.
     *
     * @param primaryStage The primary Stage is constructed by the platform.
     * @throws IOException interrupted I/O operations
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("static/TamagochiView.fxml"));
        primaryStage.setTitle("Tamagochi");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void launchApp(String[] args) {
        launch(args);
    }
}
