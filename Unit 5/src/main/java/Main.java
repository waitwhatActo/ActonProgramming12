import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main extends Application {
    public static DatabaseHandler db;

    public void start(Stage stage) throws IOException {
        stage.setTitle("Login Screen");
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/LoginScreen.fxml")));
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        db = new DatabaseHandler();

        launch(args);
    }

    public static void changeScene(javafx.event.ActionEvent actionEvent, String scene, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/" + scene + ".fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.setTitle(title);
        stage.show();
    }
}
