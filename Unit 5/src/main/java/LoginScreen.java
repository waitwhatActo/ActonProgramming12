import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    public void handleLogin(ActionEvent actionEvent) throws SQLException, IOException {
        if (username.getText().isEmpty()) {
            createAlert(Alert.AlertType.ERROR, "Please enter a valid username.", "Login Error!");
            return;
        }
        else if (password.getText().isEmpty()) {
            createAlert(Alert.AlertType.ERROR, "Please enter a password.", "Login Error!");
            return;
        }
        PreparedStatement stmt = Main.db.connection.prepareStatement( "SELECT * FROM logins WHERE username=? AND password=?" );
        stmt.setString(1, username.getText());
        stmt.setString(2, password.getText());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeScreen.fxml"));
            Parent root = loader.load();
            if (username.getText().equals("dbadmin")) {
                HomeScreen homeController = loader.getController();
                homeController.setUsername("dbadmin");
            }
            else {
                HomeScreen homeController = loader.getController();
                homeController.setUsername(username.getText());
            }
            Scene newScene = new Scene(root);
            newScene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.setTitle("Welcome!");
            stage.show();
        }
        else {
            createAlert(Alert.AlertType.ERROR, "Invalid credentials", "Login Error!");
        }
    }

    public static Alert createAlert(Alert.AlertType alertType, String message, String header) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.setHeaderText(header);
        alert.showAndWait();
        return alert;
    }
}