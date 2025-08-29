import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserList {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Integer> colId;
    @FXML
    private TableColumn<User, String> colUsername;
    @FXML
    private TableColumn<User, String> colPassword;
    private final ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        loadUsers();
    }

    private void loadUsers() {
        try {
            ResultSet rs = Main.db.executeQuery("SELECT * FROM logins");
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
            userTable.setItems(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(ActionEvent actionEvent) {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            LoginScreen.createAlert(Alert.AlertType.INFORMATION, "No user selected!", "Please select a user to delete.");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Confirm whether you want to delete user " + selectedUser.getUsername() + "?");
            alert.setHeaderText("Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK && !selectedUser.getUsername().equals("dbadmin")) {
                Main.db.executeAction("DELETE FROM logins WHERE id = " + selectedUser.getId());
                userTable.getItems().remove(selectedUser);
            }
            else if (result.isPresent() && result.get() == ButtonType.OK && selectedUser.getUsername().equals("dbadmin")) {
                LoginScreen.createAlert(Alert.AlertType.ERROR, "You cannot delete the database admin!", "This will break the program!");
            }
        }
    }

    public void editUser(ActionEvent actionEvent) throws IOException {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            LoginScreen.createAlert(Alert.AlertType.WARNING, "No user selected!", "Please select a user to edit.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserForm.fxml"));
        Parent root = loader.load();
        UserManipulation controller = loader.getController();
        controller.setUser(selectedUser);

        Scene newScene = new Scene(root);
        newScene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.setTitle("Edit User");
        stage.show();
    }


    public void addUser(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserForm.fxml"));
        Parent root = loader.load();
        UserManipulation controller = loader.getController();
        controller.setUser(null);
        Scene newScene = new Scene(root);
        newScene.getStylesheets().add(Main.class.getResource("/styles.css").toExternalForm());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.setTitle("Add User");
        stage.show();
    }
}
