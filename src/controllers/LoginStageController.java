package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginStageController {
    public TextField usernameField;
    public PasswordField passwordField;

    public void loginButton(ActionEvent actionEvent) {


        //sql request

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        //

        
    }
}
