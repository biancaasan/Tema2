# WeatherApp

WeatherAPP is a meteorological monitoring application that aims to display weather data from different cities around the world using OpenWeatherMapApi. 
This application was developped using MVC architecture and it is a JavaFX based application.

## GUI


![](/src/main/resources/images/gui.png)

#How to use the application

The user selects a country and a city and then press the search button in order to get the information about the weather.

## Language and Framework

Java
JavaFX
Maven
MVC architecture


## How to run the application

In order to run the application you need an input file which contains the city id, the name of the city, the latitude and longitude for the city and the country code.
All this information can be obtained from https://openweathermap.org/api .

### Example of input file


| ID        | nm         | lat       | lon       |  countryCode |
| --------  |:----------:| :--------:| :--------:| ------------:|
| 819827    | Razvilka   | 55.591667 | 37.740833 |     RU       |
| 524901    | Moscow     | 55.752220 | 37.615555 |     RU       |
| 2973393   | Tarascon   | 43.805828 |  4.660280 |     FR       | 



## Class Diagram

![](/src/main/resources/images/ClassDiagram.jpg)


## Activity Diagram

![](/src/main/resources/images/ActivitiesDiagram.PNG)


## Alerts

When an exception occurs will be displayed an alert box which contains a message about the reason of the alert occurance.

![](/src/main/resources/images/error.png)

## What I have learned

After this project I have learned how to work with JavaFX using MVC architecture and how to work with OpenWeatherMapApi.
