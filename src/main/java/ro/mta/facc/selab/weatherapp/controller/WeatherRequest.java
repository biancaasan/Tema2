package ro.mta.facc.selab.weatherapp.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ro.mta.facc.selab.weatherapp.Alert;
import ro.mta.facc.selab.weatherapp.model.Model;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class WeatherRequest {

    private static final String APIKEY = "e961233209fbcad95a7a0d4472f01780";
    private static final String getRequest = "http://api.openweathermap.org/data/2.5/weather?q=";


    @FXML
    Button search;

    /*this function downloads the json using the city name and returns it*/
    public String currentWeather(String city) throws IOException {
        Model myWeather = new Model();
        BufferedReader buff;
        URL url = new URL(getRequest + city + ",&units=metric&appid=" + APIKEY);
        URLConnection connection =  url.openConnection();
        buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String download = org.apache.commons.io.IOUtils.toString(buff);
        System.out.println(download);

        return download;
    }

    /*this function parse the json and set the Model*/
    public Model jsonParser(String city) throws IOException, ParseException {
        Model myWeather = new Model();

        try {
            JSONObject object =  new JSONObject(currentWeather(city));
            myWeather.setTemperature(object.getJSONObject("main").getInt("temp"));
            myWeather.setMinTemperature(object.getJSONObject("main").getDouble("temp_min"));
            myWeather.setMaxTemperature(object.getJSONObject("main").getDouble("temp_max"));
            myWeather.setHumidity(object.getJSONObject("main").getInt("humidity"));
           // int h = object.getJSONObject("main").getInt("humidity");
            // System.out.println(h);
            myWeather.setPressure(object.getJSONObject("main").getInt("pressure"));
        } catch (IOException e) {
            Alert alert = new Alert();
            alert.display("AlertBox", "Parser exception");
        }


        return myWeather;
    }

}

