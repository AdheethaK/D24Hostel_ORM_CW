package controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.NewWindowUI;
import util.Routes;

import java.io.IOException;

public class LoginFormController {

    @FXML private AnchorPane pane;
    @FXML private JFXTextField txtUsername;
    @FXML private JFXTextField txtPassword;
    @FXML private Label lblUsernameError;
    @FXML private Label lblPasswordError;
    @FXML private JFXRadioButton btnShowPassword;
    @FXML private Label imgWelcome;

    @FXML
    void imgLoginOnMouseClicked(MouseEvent event) {
        try {
            NewWindowUI.getNewWindow("MenuForm.fxml", "Main Menu",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void lblForgotPasswordOnMouseClicked(MouseEvent event) {
        System.out.println("it works! :)");
    }

    @FXML
    void imgBackOnMouseClicked(MouseEvent event) {
        try {
            NewWindowUI.getNewWindow("WelcomeForm.fxml", "Welcome Form",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

}



