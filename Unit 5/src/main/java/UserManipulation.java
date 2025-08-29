import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserManipulation {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label formTitle;
    @FXML
    private Button actionButton;

    private User user;
    private boolean editMode;

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            editMode = true;
            formTitle.setText("Edit User");
            actionButton.setText("Save Changes");
            username.setText(user.getUsername());
            password.setText(user.getPassword());
        } else {
            editMode = false;
            formTitle.setText("Create User");
            actionButton.setText("Create");
        }
    }

    @FXML
    private void handleAction(ActionEvent actionEvent) throws SQLException, IOException {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            LoginScreen.createAlert(Alert.AlertType.ERROR,
                    "Please enter a username and password.",
                    "Insufficient Information");
            return;
        }

        if (editMode) {
            String sql = "UPDATE logins SET username='" + username.getText() +
                    "', password='" + password.getText() +
                    "' WHERE id=" + user.getId();
            DatabaseHandler.sqlStatement.execute(sql);
        } else {
            String sql = "INSERT INTO logins (username, password) VALUES ('" +
                    username.getText() + "', '" + password.getText() + "')";
            DatabaseHandler.sqlStatement.execute(sql);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserList.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.setTitle("User List");
        stage.show();
    }
}
