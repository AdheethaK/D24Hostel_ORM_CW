package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route){
            case StudentTableForm:
                initUI("/view/StudentTableForm.fxml");
                break;
            case RoomTableForm:
                initUI("/view/RoomTableForm.fxml");
                break;
            case ReservationTableForm:
                initUI("/view/ReservationTableForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR,"UI not found!").show();
        }
    }
    public static FXMLLoader initUI(String location) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource(location));
        Parent parent = fxmlLoader.load();
        Navigation.pane.getChildren().add(parent);

        return fxmlLoader;
    }
}
