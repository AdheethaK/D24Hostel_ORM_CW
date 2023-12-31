package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.*;
import dto.RoomDTO;
import dto.StudentDTO;
import dto.TM.RoomTM;
import dto.TM.StudentTM;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.NewWindowUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

    @FXML private TableView<StudentTM> tblStudent;
    @FXML private TableColumn<StudentTM,String> colID;
    @FXML private TableColumn<StudentTM,String> colNAME;
    @FXML private TableColumn<StudentTM,String> colADDRESS;
    @FXML private TableColumn<StudentTM,String> colCONTACTNO;
    @FXML private TableColumn<StudentTM, LocalDate> colDOB;
    @FXML private TableColumn<StudentTM,String> colGENDER;
    @FXML private JFXButton btnRefreshTable;
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

    ObservableList<String> ObList_gender = FXCollections.observableArrayList();
    private ObservableList<StudentTM> obList_tbl = FXCollections.observableArrayList();

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCmbGender();
        setPropertyValueFactory();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) { //➕ NEW ID

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) { //🔃
        if(update()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Student successfully updated! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in student table! :(").show();
        }
    }
    private boolean update(){
        boolean isUpdated = false;
        try {
            isUpdated = studentBO.update(fillObject_Room());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) { //🗑️
        if(delete()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Student successfully deleted! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in student table! :(").show();
        }
    }
    private boolean delete(){
        boolean isDeleted = false;
        try {
            isDeleted = studentBO.delete(txtStudentID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) { //🔍
        if(!search()) new Alert(Alert.AlertType.ERROR,"oops! this student does not exist! :(").show();
    }
    private boolean search(){
        boolean isExist = false;
        try {
            StudentDTO studentDTO = studentBO.search(txtStudentID.getText());
            fillAllFields(studentDTO);
            if(studentDTO != null) isExist = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
    private void fillAllFields(StudentDTO studentDTO){
        txtStudentID.setText(studentDTO.getId());
        txtName.setText(studentDTO.getName());
        txtAddress.setText(studentDTO.getAddress());
        txtContactNo.setText(studentDTO.getContactNo());
        datePickDOB.setValue(studentDTO.getDob());
        cmbGender.setValue(studentDTO.getGender());
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) { //✔️
        if(save()){
            new Alert(Alert.AlertType.CONFIRMATION,"Congratulations! Student successfully saved! :)").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"oops! something happened in student table! :(").show();
        }
    }
    private boolean save(){
        boolean isSaved = false;
        try {
            isSaved = studentBO.add(fillObject_Room());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSaved;
    }
    //fill obj room
    private StudentDTO fillObject_Room(){
        return new StudentDTO(
               txtStudentID.getText(),
               txtName.getText(),
               txtAddress.getText(),
               txtContactNo.getText(),
               datePickDOB.getValue(),
               cmbGender.getValue()
        );
    }

    @FXML
    void btnEraseOnAction(ActionEvent event) { //⌫

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

    @FXML
    void btnRefreshTableOnAction(ActionEvent actionEvent) {
        ArrayList<StudentTM> tms = new ArrayList<>();
        try {
            ArrayList<StudentDTO> studentDTOS = studentBO.getAll();
            for (StudentDTO s : studentDTOS){
                tms.add(new StudentTM(
                        s.getId(),
                        s.getName(),
                        s.getAddress(),
                        s.getContactNo(),
                        s.getDob(),
                        s.getGender()
                ));
            }
            for (StudentTM studentTM: tms){
                obList_tbl.add(studentTM);
            }
            tblStudent.setItems(obList_tbl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //fill the gender comboBox
    private void setCmbGender(){
        List<String> genderList = new ArrayList<>();
        genderList.add("female");
        genderList.add("male");
        genderList.add("rather not say");

        for (String gender : genderList){
            ObList_gender.add(gender);
        }
        cmbGender.setItems(ObList_gender);
    }

    private void setPropertyValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        colADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCONTACTNO.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGENDER.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }
}

