package ro.mta.facc.selab.weatherapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.json.simple.parser.ParseException;
import ro.mta.facc.selab.weatherapp.Alert;
import ro.mta.facc.selab.weatherapp.model.Model;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    DataFromFile d = new DataFromFile();

    @FXML
    private ComboBox<String> countries;

    @FXML
    private ComboBox<String> cities;

    @FXML
    private Button search;


    /*this function initialize the combobox for cities and the combobox for countries
    using the returned array list from DataFromFile class*/
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> myCountriesL = null;
        ArrayList<String> myCitiesL = null;
        try {
            myCountriesL = d.readCountries();
        } catch (IOException e) {
            Alert alert = new Alert();
            alert.display("Alert box", "The list which contains countries is empty");
        }
        try {
            myCitiesL = d.readCities();
        } catch (IOException e) {
            Alert alert = new Alert();
            alert.display("Alert box", "The list which contains cities is empty");
        }

        //System.out.println(myCountriesL);
        //System.out.println(myCitiesL);

        /*set combobox for countries*/
        ObservableList<String> data = FXCollections.observableArrayList(myCountriesL.get(0),myCountriesL.get(2),myCountriesL.get(4),myCountriesL.get(6),myCountriesL.get(8),myCountriesL.get(10));
        //countries.setItems(data);
        countries.getItems().addAll(data);

        countries.setValue("IT");
        cities.setValue("Venice");
        //System.out.println(cities.getValue());

       // search.setOnAction(e -> print());

        //System.out.println(cities.getEditor().getText());

       // System.out.println(countries .getSelectionModel().getSelectedItem());

        /* because of a problem I can't display only cities for a specific country so I have to do this way*/
        if(countries.getValue().equals("UAE")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(0),myCitiesL.get(1));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("GER")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(2),myCitiesL.get(3));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("AT")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(4),myCitiesL.get(5));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("FR")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(6),myCitiesL.get(7));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("SE")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(8),myCitiesL.get(9));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("GR")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(10),myCitiesL.get(11));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("PL")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(12),myCitiesL.get(13));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("SVK")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(14),myCitiesL.get(15));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("POR")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(16),myCitiesL.get(17));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("ES")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(18),myCitiesL.get(19));
            cities.getItems().addAll(dataI);
        }

        if(countries.getValue().equals("IT")){
            ObservableList<String> dataI = FXCollections.observableArrayList (myCitiesL.get(20),myCitiesL.get(21));
            cities.getItems().addAll(dataI);
        }

        /*set combobox for cities*/
        // ObservableList<String> dataC = FXCollections.observableArrayList(myCitiesL);
        // cities.setItems(dataC);

        WeatherRequest W = new WeatherRequest();
         try {
            //System.out.println(cities.getValue());
            //W.currentWeather(cities.getValue());
           Model m =  W.jsonParser(cities.getValue());
           displayWeather(m);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    public void print() {
       // System.out.println(cities.getValue());
       // System.out.println(countries.getValue());
       System.out.println("You want to receive meteo info about " + cities.getValue() + " from " + countries.getValue());
    }

    public String getCity(){
        return cities.getValue();
    }

    public String getCountry(){
        return countries.getValue();
    }

    /*display the value from city combobox*/
    public void printCity(MouseEvent mouseEvent) {
        //System.out.println(cities.getValue());
    }

    /*display the value from country combobox*/
    public void printCountry(MouseEvent mouseEvent) {
      //  System.out.println(countries.getValue());
    }

    /*this function displays the information about weather*/
    void displayWeather(Model model){
            System.out.println("Temperature: " + model.getTemperature());
            System.out.println("Humidity: " + model.getHumidity());
            System.out.println("Max temperature: " + model.getMaxTemperature());
            System.out.println("Min temperature: " + model.getMinTemperature());
    }

}
