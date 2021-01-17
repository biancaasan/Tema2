package ro.mta.facc.selab.weatherapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*the Alert class display an alert box when an exception is caught*/

public class Alert {

    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(260);

        Label label = new Label();
        label.setText(message);

        Button closeBttn = new Button();
        closeBttn.setOnAction(actionEvent -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeBttn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
