package controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.NewWindowUI;

import java.io.IOException;

public class StudentFormController {
    @FXML private AnchorPane pane;
    @FXML private JFXTextField txtStudentID;
    @FXML private JFXTextField txtName;
    @FXML private JFXTextField txtContactNo;
    @FXML private JFXTextArea txtAddress;
    @FXML private JFXComboBox<String> cmbGender;
    @FXML private JFXDatePicker datePickDOB;
    @FXML private Label lblStudentIdError;
    @FXML private Label lblNameError;
    @FXML private Label lblContactNoError;
    @FXML private Label lblDOBError;
    @FXML private Label lblGenderError;
    @FXML private Label lblAddressError;
    @FXML private JFXButton btnAdd;
    @FXML private JFXButton btnUpdate;
    @FXML private JFXButton btnDelete;
    @FXML private JFXButton btnSearch;
    @FXML private JFXButton btnSave;
    @FXML private JFXButton btnErase;
    @FXML private ImageView imgProfile;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnEraseOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void imgBackOnMouseClicked(MouseEvent event) {
        try {
            NewWindowUI.getNewWindow("MenuForm.fxml", "Main Menu",pane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }

    @FXML
    void imgEditOnMouseClicked(MouseEvent event) {
        System.out.println("it works! :)");
    }

    @FXML
    void imgProfileOnMouseClick(MouseEvent event) {
        System.out.println("it works! :)");
    }

    @FXML
    void imgSaveOnMouseClicked(MouseEvent event) {
        System.out.println("it works! :)");
    }

}

