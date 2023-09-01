package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWindowUI {
    public static void getNewWindow(String location , String title, AnchorPane root) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(NewWindowUI.class.getResource("/view/"+location));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.centerOnScreen();
    }
}
