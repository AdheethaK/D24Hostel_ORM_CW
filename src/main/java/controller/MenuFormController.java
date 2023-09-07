package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import util.Navigation;
import util.NewWindowUI;
import util.Routes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MenuFormController implements Initializable {

    @FXML private ImageView imgtblStudent;
    @FXML private ImageView imgtblRoom;
    @FXML private ImageView imgtblReserved;
    @FXML private Label lblTblName;
    @FXML private ImageView imgTable;
    @FXML private AnchorPane tblPane;
    @FXML private AnchorPane pane;
    @FXML private JFXButton btnStudent;
    @FXML private JFXButton btnRoom;
    @FXML private JFXButton btnReservation;
    @FXML private Label lblDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDateAndTime();
    }

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
        try {
            Navigation.navigate(Routes.ReservationTableForm,tblPane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
        //change opacity of image view
        if(!(imgtblStudent.getOpacity()==1))setOpacityStudent(1);
        if(!(imgtblRoom.getOpacity()==1))setOpacityRoom(1);
        setOpacityReservation(0);
        //set lbl
        lblTblName.setText("Reserved Table");
        //set img
        settblImage(3);
    }

    @FXML
    void imgtblRoomOnMouseClicked(MouseEvent event) {
        try {
            Navigation.navigate(Routes.RoomTableForm,tblPane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
        //change opacity of image view
        if(!(imgtblStudent.getOpacity()==1))setOpacityStudent(1);
        if(!(imgtblReserved.getOpacity()==1))setOpacityReservation(1);
        setOpacityRoom(0);
        //set lbl
        lblTblName.setText("Room Table");
        //set img
        settblImage(2);
    }

    @FXML
    void imgtblStudentOnMouseClicked(MouseEvent event) {
        try {
            Navigation.navigate(Routes.StudentTableForm,tblPane);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
        //change opacity of image view
        if(!(imgtblReserved.getOpacity()==1))setOpacityReservation(1);
        if(!(imgtblRoom.getOpacity()==1))setOpacityRoom(1);
        setOpacityStudent(0);
        //set lbl
        lblTblName.setText("Student Table");
        //set img
        settblImage(1);
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

    private void setOpacityStudent(int num){ // change opacity for imgtblStudent
        switch(num){
            case 1:imgtblStudent.setOpacity(1);break;
            case 0:imgtblStudent.setOpacity(0.5);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    private void setOpacityRoom(int num){ // change opacity for imgtblRoom
        switch(num){
            case 1:imgtblRoom.setOpacity(1);break;
            case 0:imgtblRoom.setOpacity(0.5);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    private void setOpacityReservation(int num){ // change opacity for imgtblReserved
        switch(num){
            case 1:imgtblReserved.setOpacity(1);break;
            case 0:imgtblReserved.setOpacity(0.5);break;
            default:new Alert(Alert.AlertType.ERROR,"invalid argument! :0").show();
        }
    }

    private void settblImage(int num){ //Student-->1  Room-->2 Reserved-->3
        switch (num){
            case 1:
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\graduation.png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgTable.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            case 2:
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\bed (2).png";
                    InputStream stream = new FileInputStream(imageLocation);
                    Image image = new Image(stream);

                    imgTable.setImage(image);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR,"Image not found!").show();
                }
                break;
            case 3:
                try {
                    String imageLocation = "D:\\My Projects\\HIBERNATE\\D24Hostel\\src\\main\\resources\\img\\reservation (2).png";
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

}


