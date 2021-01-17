package ro.mta.facc.selab.weatherapp.controller;

import ro.mta.facc.selab.weatherapp.Alert;

import java.io.*;
import java.util.ArrayList;


/* The class DataFromFile has methods that are able to read the data from the input file
    and return an array list which contain the countries and another one which contain
    the cities
 */

public class DataFromFile {

    public ArrayList<String> readCities() throws IOException {

        File inputFile = new File("C:/Users/Bianca/Desktop/ANUL4/IP/Proiect/Cities.txt");

        ArrayList<String> cities = new ArrayList<>();

        try {
            if (inputFile.exists()) {
                BufferedReader buff = new BufferedReader(new FileReader(inputFile));

                String line;
                String[] words = new String[0];
                String city = null;

                while ((line = buff.readLine()) != null) {
                    words = line.split("\\s+");
                    city = words[1];
                    cities.add(city);
                    // System.out.println(cities);
                }
            }
        }catch(FileNotFoundException e){
            Alert alert = new Alert();
            alert.display("Alert box", "File not found!");
        }
        return cities;
    }

    /* read countries from input file*/
    public ArrayList<String> readCountries() throws IOException {

        File inputFile = new File("C:/Users/Bianca/Desktop/ANUL4/IP/Proiect/Cities.txt");

        ArrayList<String> countries = new ArrayList<>();
        try{
        if (inputFile.exists()) {
            BufferedReader buff = new BufferedReader(new FileReader(inputFile));

            String line;
            String[] words = new String[0];
            String country = null;

            while ((line = buff.readLine()) != null) {
                words = line.split("\\s+");
                country = words[4];
                countries.add(country);
                //System.out.println(countries);
            }
        }
        }catch(FileNotFoundException e){
            Alert alert = new Alert();
            alert.display("Alert box", "File not found!");
        }
        return countries;
    }

}
