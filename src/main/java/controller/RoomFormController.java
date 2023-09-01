package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import entity.Room;
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
import java.net.URL;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    @FXML private AnchorPane pane;
    @FXML private Label lblRoomTypeIDError;
    @FXML private Label lblTypeError;
    @FXML private Label lblKeyMoneyError;
    @FXML private Label lblQTYError;
    @FXML private JFXTextField txtRoomTypeID;
    @FXML private JFXTextField txtType;
    @FXML private JFXTextField txtKeyMoney;
    @FXML private JFXTextField txtQTY;
    @FXML private JFXButton btnAdd;
    @FXML private JFXButton btnUpdate;
    @FXML private JFXButton btnDelete;
    @FXML private JFXButton btnSearch;
    @FXML private JFXButton btnSave;
    @FXML private JFXButton btnErase;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {//➕ NEW ID

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {//🔃
        if(update()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Room successfully updated! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in room table! :(").show();
        }
    }
    private boolean update(){
        boolean isUpdated = false;
        try {
            isUpdated = roomBO.update(fillObject_Room());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {//🗑️
        if(delete()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Room successfully deleted! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in room table! :(").show();
        }
    }
    private boolean delete(){
        boolean isDeleted = false;
        try {
            isDeleted = roomBO.delete(txtRoomTypeID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {//🔍
        if(!search()) new Alert(Alert.AlertType.ERROR,"oops! this room does not exist! :(").show();
    }
    private boolean search(){
        boolean isExist = false;
        try {
            RoomDTO roomDTO = roomBO.search(txtRoomTypeID.getText());
            fillAllFields(roomDTO);
            if(roomDTO != null) isExist = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
    private void fillAllFields(RoomDTO roomDTO){
        txtRoomTypeID.setText(roomDTO.getRoomTypeId());
        txtType.setText(roomDTO.getType());
        txtKeyMoney.setText(Double.toString(roomDTO.getKeyMoney()));
        txtQTY.setText(Integer.toString(roomDTO.getQty()));
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {//✔️
        if(save()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Room successfully saved! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in room table! :(").show();
        }
    }
    private boolean save(){
        boolean isSaved = false;
        try {
            isSaved = roomBO.add(fillObject_Room());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSaved;
    }
    //fill obj room
    private RoomDTO fillObject_Room(){
        return new RoomDTO(
                txtRoomTypeID.getText(),
                txtType.getText(),
                Double.parseDouble(txtKeyMoney.getText()),
                Integer.parseInt(txtQTY.getText())
        );
    }

    @FXML
    void btnEraseOnAction(ActionEvent event) {//⌫

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
}

