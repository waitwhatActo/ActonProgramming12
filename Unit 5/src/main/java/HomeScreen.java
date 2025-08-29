import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreen {
    @FXML
    private Label welcomeLabel;
    @FXML
    private ButtonBar adminControls;
    @FXML
    private Label joke;


    public void setUsername(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
        if ("dbadmin".equals(username)) {
            adminControls.setVisible(true);
            adminControls.setManaged(true);
            joke.setVisible(false);
        }
    }
    public void logout(ActionEvent actionEvent) {
        try {
            Main.changeScene(actionEvent, "LoginScreen", "Login Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userlist(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/UserList.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(newScene);
        stage.setTitle("User List");
        stage.show();
    }
}
