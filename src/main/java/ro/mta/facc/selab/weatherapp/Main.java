package ro.mta.facc.selab.weatherapp;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import ro.mta.facc.selab.weatherapp.controller.DataFromFile;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
        //DataFromFile f = new DataFromFile();
        //System.out.println(f.readCities());
        //System.out.println(f.readCountries());
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(this.getClass().getResource("/view/sample.fxml"));
            stage.setScene(new Scene((Parent)loader.load()));
             stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
