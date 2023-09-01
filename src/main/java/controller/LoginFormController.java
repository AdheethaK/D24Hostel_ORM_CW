package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class LoginFormController {

    @FXML private AnchorPane pane;
    @FXML private ImageView imgExit;
    @FXML private JFXButton btnLogin;
    @FXML private JFXButton btnSignUp;
    @FXML private JFXButton btnCancel;

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {
            Navigation.navigate(Routes.MenuForm,pane);
        } catch (IOException exception) {
            exception.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }

    @FXML
    void imgExitOnMouseClicked(MouseEvent event) {
        Stage stage = (Stage) imgExit.getScene().getWindow();
        stage.close();
    }

}


