package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import dto.TM.RoomTM;
import entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.NewWindowUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    @FXML private TableView<RoomTM> tblRoom;
    @FXML private TableColumn colID;
    @FXML private TableColumn colTYPE;
    @FXML private TableColumn colFOOD;
    @FXML private TableColumn colAC;
    @FXML private TableColumn colKEYMONEY;
    @FXML private TableColumn colQTY;
    @FXML private Label lblDate;
    @FXML private ImageView imgProfile;
    @FXML private Label lblUserFullname;
    @FXML private JFXCheckBox checkBoxFood;
    @FXML private JFXCheckBox checkBoxAC;
    @FXML private ImageView imgFood;
    @FXML private ImageView imgAC;
    @FXML private JFXButton btnRefreshTable;
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

    private ObservableList<RoomTM> obList_room = FXCollections.observableArrayList();

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setPropertyValueFactory();
        setDateAndTime();
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
        fillCheckBoxFOODField(roomDTO.isTypeFOOD());
        fillCheckBoxACField(roomDTO.isTypeAC());
        txtKeyMoney.setText(Double.toString(roomDTO.getKeyMoney()));
        txtQTY.setText(Integer.toString(roomDTO.getQty()));
    }
    //set typeFOOD value
    private void fillCheckBoxFOODField(boolean value){
        if (value == true){
            checkBoxFood.setSelected(true);
        }else {
            checkBoxFood.setSelected(false);
        }
    }
    //set typeAC value
    private void fillCheckBoxACField(boolean value){
        if (value == true){
            checkBoxAC.setSelected(true);
        } else {
            checkBoxAC.setSelected(false);
        }
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
                getTypeFOOD(),
                getTypeAC(),
                Double.parseDouble(txtKeyMoney.getText()),
                Integer.parseInt(txtQTY.getText())
        );
    }
    //get typeFOOD value
    private boolean getTypeFOOD(){
        if (checkBoxFood.isSelected()){
            return true;
        }else {
            return false;
        }
    }
    //get typeAC value
    private boolean getTypeAC(){
        if (checkBoxAC.isSelected()){
            return true;
        }else {
            return false;
        }
    }

    @FXML
    void  btnRefreshTableOnAction(ActionEvent actionEvent) {
        ArrayList<RoomTM> list = new ArrayList<>();
        String imgLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\check.png";
        ImageView img = new ImageView(new Image(this.getClass().getResourceAsStream(imgLocation), 50, 50, false, false));
        try {
            ArrayList<RoomDTO> roomDTOS = roomBO.getAll();
            for (RoomDTO roomDTO: roomDTOS){
                list.add(new RoomTM(
                        roomDTO.getRoomTypeId(),
                        img,
                        img,
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"oops! something happened in room table! :(").show();
        }
        for(RoomTM ob:list){
            obList_room.add(ob);
        }
        tblRoom.setItems(obList_room);
    }
    private ImageView getImageView(int num){ //create images for column food and column ac
        switch (num){//1-->yes   2--->no
            case 1:
                String locationYES = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\check.png";
                Image imageYES = new Image(this.getClass().getResourceAsStream(locationYES), 50, 50, false, false);
                return new ImageView(imageYES);
            case 2:
                String locationNO = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\block.png";
                Image imageNO = new Image(this.getClass().getResourceAsStream(locationNO), 50, 50, false, false);
                return new ImageView(imageNO);
            default:new Alert(Alert.AlertType.ERROR,"oops! invalid argument! :(").show();
        }
        return null;
    }

    @FXML
    void checkBoxFoodOnAction(ActionEvent actionEvent) {
        if(checkBoxFood.isSelected()){
            setOpacityImgFood(1);
        }else {
            setOpacityImgFood(0);
        }
    }

    private void setOpacityImgFood(int num){ //halfOpacity-->0  fullOpacity-->1
        switch (num){
            case 0:imgFood.setOpacity(0.5);break;
            case 1:imgFood.setOpacity(1);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    @FXML
    void checkBoxACOnAction(ActionEvent actionEvent) {
        if (checkBoxAC.isSelected()){
            setOpacityImgAC(1);
        }else {
            setOpacityImgAC(0);
        }
    }

    private void setOpacityImgAC(int num){ //halfOpacity-->0  fullOpacity-->1
        switch (num){
            case 0:imgAC.setOpacity(0.5);break;
            case 1:imgAC.setOpacity(1);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    @FXML
    void btnEraseOnAction(ActionEvent event) {//⌫

    }

    public void imgProfileOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void lblUserFullnameOnMouseClicked(MouseEvent mouseEvent) {
    }

    private void setDateAndTime(){
        // 1. get date/time
        Date currentDateTime = new Date();

        // 2. get Date with Zone & AM/PM marker
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a z");
        String formatterDateTime = dateFormat.format(currentDateTime);

        //set value to lbl
        lblDate.setText(formatterDateTime);
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

    private void setPropertyValueFactory(){
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        colFOOD.setCellValueFactory(new PropertyValueFactory<>("food"));
        colAC.setCellValueFactory(new PropertyValueFactory<>("ac"));
        colKEYMONEY.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

}

