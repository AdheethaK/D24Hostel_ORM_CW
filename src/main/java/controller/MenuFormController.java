package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import util.Navigation;
import util.NewWindowUI;
import util.Routes;

import java.io.IOException;

public class MenuFormController {

    @FXML private AnchorPane tblPane;
    @FXML private AnchorPane pane;
    @FXML private JFXButton btnStudent;
    @FXML private JFXButton btnRoom;
    @FXML private JFXButton btnReservation;
    @FXML private Label lblDate;

    @FXML
    void btnReservationOnAction(ActionEvent event) {
        try {
            NewWindowUI.getNewWindow("ReservationForm.fxml", "Room Form",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void btnRoomOnAcrion(ActionEvent event) {
        try {
            NewWindowUI.getNewWindow("RoomForm.fxml", "Room Form",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        try {
            NewWindowUI.getNewWindow("StudentForm.fxml", "Student Form",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void imgBackOnMouseClicked(MouseEvent event) {
        try {
            NewWindowUI.getNewWindow("LoginForm.fxml", "Login Form",pane);
        } catch (IOException exception) {
            exception.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void imgtblReservedOnMouseClicked(MouseEvent event) {
        System.out.println("it works! :0");
    }

    @FXML
    void imgtblRoomOnMouseClicked(MouseEvent event) {
        System.out.println("it works! :0");
    }

    @FXML
    void imgtblStudentOnMouseClicked(MouseEvent event) {
        try {
            Navigation.navigate(Routes.StudentTableForm,tblPane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

}


