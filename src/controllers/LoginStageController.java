package controllers;

import daoImpl.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Strings;
import utils.Utils;

import java.io.IOException;

public class LoginStageController {
    public TextField usernameField;
    public PasswordField passwordField;
    public Text errorText;

    public void loginButton(ActionEvent actionEvent) {



        UserDao userDao = new UserDao();
        String username = usernameField.getText();
        String pass = passwordField.getText();

        //aby nie wpisywać hasła caly czas *******



        Parent root2 = null;
        try {
            root2 = FXMLLoader.load(getClass().getResource(Utils.getLayoutFolder() + "hub_stage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage newStage2 = new Stage();
        newStage2.setTitle("Hub Stage");
        newStage2.setScene(new Scene(root2, 800, 600));
        newStage2.show();
        //close this stage
        final Node source2 = (Node) actionEvent.getSource();
        final Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();

        //*************


        if(username.length() > 5 ) {
            if(pass.length() > 5) {
                if (userDao.isUserExist(username)) {
                    if(userDao.isUserPasswordCorrect(username, pass)){
                        errorText.setText("");
                        //ok - start hub stage
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource(Utils.getLayoutFolder() + "hub_stage.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage newStage = new Stage();
                        newStage.setTitle("Hub Stage");
                        newStage.setScene(new Scene(root, 600, 400));
                        newStage.show();
                        //close this stage
                        final Node source = (Node) actionEvent.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();

                    } else {
                        errorText.setText(Strings.WRONG_PASSWORD);
                        // wrong password
                    }
                } else {
                    errorText.setText(Strings.USER_NOT_EXIST);
                    // user not exist
                }
            }else{
                errorText.setText(Strings.PASSWORD_TOO_SHORT);
                // password to short
            }
        }else{
            errorText.setText(Strings.WRONG_USERNAME);
            // username too short
        }
    }
}
