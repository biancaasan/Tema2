package ro.mta.facc.selab.weatherapp.controller;

import ro.mta.facc.selab.weatherapp.Alert;
import ro.mta.facc.selab.weatherapp.model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*The class Logger creates the file with information about the weather searched*/

public class Logger {

    private static Logger logger = null;
    private final File logFile;
    private FileWriter fileWriter;
    private final String logString = "[INFO]: ";

    public Logger(File logFile) {
        this.logFile = logFile;
    }

    public static Logger getInstance(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public Logger() {
        logFile = new File("loggers");
        try {
            logFile.createNewFile();
            fileWriter = new FileWriter(logFile);
        }catch (IOException e){
            Alert alert = new Alert();
            alert.display("Alert box", "Can't open the file!");
        }
    }

    public void close(){
        try {
            fileWriter.close();
        }catch (IOException e){
            Alert alertClass = new Alert();
            alertClass.display("Alert box", "Can't close the file");
        }
    }

    public boolean log(Model myWeather, String city, String country){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String message;
        message = formatter.format(date) + logString + country + " " + city + " temp" + myWeather.getTemperature() + " humidity" + myWeather.getHumidity() + "\n";

        try {
            fileWriter.write(message);
        }catch (IOException e){
            Alert alertClass = new Alert();
            alertClass.display("Alert box", "Can't write");
        }
        return true;
    }
}
