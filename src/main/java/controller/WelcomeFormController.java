package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.NewWindowUI;

import java.io.IOException;

public class WelcomeFormController {

    @FXML private AnchorPane pane;
    @FXML private Label imgWelcome;
    @FXML private ImageView imgClose;

    @FXML
    void imgCloseOnMouseClicked(MouseEvent event) {
        Stage stage = (Stage) imgClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void imgWelcomeOnMouseClicked(MouseEvent event) {
        try {
            NewWindowUI.getNewWindow("LoginForm.fxml", "Main Menu",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

}

