package controller;

import bo.BOFactory;
import bo.custom.ReservationBO;
import bo.custom.RoomBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.NewWindowUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    @FXML private ImageView imgProfile;
    @FXML private Label lblUserFullname;
    @FXML private ImageView imgTable;
    @FXML private Label lblTable;
    @FXML private Label lblDate;
    @FXML private JFXDatePicker datePickerArrival;
    @FXML private Label lblArrivalDateError;
    @FXML private JFXDatePicker datePickerDeparture;
    @FXML private Label lblDepartureDateError;
    @FXML private JFXButton btnRefreshTable;
    @FXML private ImageView imgStatus;
    @FXML private ImageView imgSelectAll;
    @FXML private ImageView imgSelectUnpaid;
    @FXML private ImageView imgSelectPaid;
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
    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillStudentIds();
        fillRoomTypeIds();
        fillStatus();
        setDateAndTime();
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
        if(save()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Reservation successfully saved! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in reservation table! :(").show();
        }
    }
    private boolean save(){
        boolean isSaved = false;
        try {
            isSaved = reservationBO.add(fillObject_Reservation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSaved;
    }
    //fill obj room
    private ReservationDTO fillObject_Reservation(){
        return new ReservationDTO(
                txtReservationID.getText(),
                datePickerArrival.getValue(),
                datePickerDeparture.getValue(),
                getStudent(cmbStudentID.getValue()),
                getRoom(cmbRoomType.getValue()),
                cmbStatus.getValue()
        );
    }
    private StudentDTO getStudent(String id){//get the student for the id
        try {
            StudentDTO studentDTO = studentBO.search(id);
            if(studentDTO != null) return studentDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private RoomDTO getRoom(String id){//get the room for the id
        try {
            RoomDTO roomDTO = roomBO.search(id);
            if(roomDTO != null) return roomDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    void btnEraseOnAction(ActionEvent event) {

    }

    @FXML
    void  datePickerArrivalOnAction(ActionEvent actionEvent) {
    }

    @FXML
    void  datePickerDepartureOnAction(ActionEvent actionEvent) {
    }

    @FXML
    void  btnRefreshTableOnAction(ActionEvent actionEvent) {
    }

    @FXML
    void  imgTableOnMouseClicked(MouseEvent mouseEvent) {
    }

    @FXML
    void imgSelectAllOnMouseClicked(MouseEvent mouseEvent) {
        //change opacity of image view
        if(!(imgSelectUnpaid.getOpacity()==1))setOpacityImgSelectUnpaid(1);
        if(!(imgSelectPaid.getOpacity()==1))setOpacityImgSelectPaid(1);
        setOpacityImgSelectAll(0);
        //set lbl
        lblTable.setText("RESERVATIONS ALL");
        //set img
        settblImage(1);
    }

    @FXML
    void imgSelectUnpaidOnMouseClicked(MouseEvent mouseEvent) {
        //change opacity of image view
        if(!(imgSelectAll.getOpacity()==1))setOpacityImgSelectAll(1);
        if(!(imgSelectPaid.getOpacity()==1))setOpacityImgSelectPaid(1);
        setOpacityImgSelectUnpaid(0);
        //set lbl
        lblTable.setText("RESERVATIONS UNPAID");
        //set img
        settblImage(2);
    }

    @FXML
    void imgSelectPaidOnMouseClicked(MouseEvent mouseEvent) {
        //change opacity of image view
        if(!(imgSelectAll.getOpacity()==1))setOpacityImgSelectAll(1);
        if(!(imgSelectUnpaid.getOpacity()==1))setOpacityImgSelectUnpaid(1);
        setOpacityImgSelectPaid(0);
        //set lbl
        lblTable.setText("RESERVATIONS PAID");
        //set img
        settblImage(3);
    }

    private void setOpacityImgSelectAll(int num){ // change opacity for imgSelectAll
        switch(num){
            case 1:imgSelectAll.setOpacity(1);break;
            case 0:imgSelectAll.setOpacity(0.5);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }
    private void setOpacityImgSelectUnpaid(int num){ // change opacity for imgSelectUnpaid
        switch(num){
            case 1:imgSelectUnpaid.setOpacity(1);break;
            case 0:imgSelectUnpaid.setOpacity(0.5);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }
    private void setOpacityImgSelectPaid(int num){ // change opacity for imgSelectPAid
        switch(num){
            case 1:imgSelectPaid.setOpacity(1);break;
            case 0:imgSelectPaid.setOpacity(0.5);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }
    private void settblImage(int num){ //SelectAll-->1  SelectUnpaid-->2 SelectPaid->3
        switch (num){
            case 1:
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\tick-box.png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgTable.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            case 2:
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\\\payday.png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgTable.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            case 3:
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\paid.png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgTable.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    @FXML
    void  cmbStatusOnAction(ActionEvent actionEvent) {
        switch (cmbStatus.getValue()){
            case "Paid":
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\paid.png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgStatus.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            case "Unpaid":
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\payday.png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgStatus.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    @FXML
    void  lblUserFullnameOnMouseClicked(MouseEvent mouseEvent) {
    }

    @FXML
    void  imgProfileOnMouseClicked(MouseEvent mouseEvent) {
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

    private void setDateAndTime(){
        // 1. get date/time
        Date currentDateTime = new Date();

        // 2. get Date with Zone & AM/PM marker
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a z");
        String formatterDateTime = dateFormat.format(currentDateTime);

        //set value to lbl
        lblDate.setText(formatterDateTime);
    }

}

