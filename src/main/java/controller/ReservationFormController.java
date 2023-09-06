package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.NewWindowUI;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    @FXML private AnchorPane pane;
    @FXML private Label lblRoomTypeIDError;
    @FXML private Label lblTypeError;
    @FXML private Label lblKeyMoneyError;
    @FXML private Label lblQTYError;
    @FXML private JFXComboBox<String> cmbStatus;
    @FXML private Label lblQTYError1;
    @FXML private JFXTextField txtReservationID;
    @FXML private JFXComboBox<String> cmbRoomType;
    @FXML private JFXComboBox<String> cmbStudentID;
    @FXML private JFXDatePicker datePickerDate;
    @FXML private JFXButton btnAdd;
    @FXML private JFXButton btnUpdate;
    @FXML private JFXButton btnDelete;
    @FXML private JFXButton btnSearch;
    @FXML private JFXButton btnSave;
    @FXML private JFXButton btnErase;

    ObservableList<String> obList_studentId = FXCollections.observableArrayList();
    ObservableList<String> obList_roomTypeId = FXCollections.observableArrayList();
    ObservableList<String> obList_status = FXCollections.observableArrayList();

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillStudentIds();
        fillRoomTypeIds();
        fillStatus();
    }

    @FXML
    void addStudentOnMouseClicked(MouseEvent event) {
        System.out.println("it works! :)");
    }

    @FXML
    void btnAddOnAction(ActionEvent event) { //➕ NEW ID

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) { //🔃

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) { //🗑️

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) { //🔍

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) { //✔️

    }

    @FXML
    void btnEraseOnAction(ActionEvent event) {

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

    private void fillStudentIds(){
        try {
            ArrayList<String> idList = studentBO.getAllIds();
            if(idList!=null){
                for (String id : idList){
                    obList_studentId.add(id);
                }
                cmbStudentID.setItems(obList_studentId);
            }else{
                new Alert(Alert.AlertType.ERROR,"oops! something happened! :(").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"oops! something happened! :(").show();
        }
    }

    private void fillRoomTypeIds(){
        try {
            ArrayList<String> idList = roomBO.getAllIds();
            if(idList!=null){
                for (String id : idList){
                    obList_roomTypeId.add(id);
                }
                cmbRoomType.setItems(obList_roomTypeId);
            }else{
                new Alert(Alert.AlertType.ERROR,"oops! something happened! :(").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"oops! something happened! :(").show();
        }
    }

    private void fillStatus(){
        ArrayList<String> statusList = new ArrayList<>();
        statusList.add("Paid");
        statusList.add("Unpaid");

        for (String status:statusList){
            obList_status.add(status);
        }
        cmbStatus.setItems(obList_status);
    }

}

