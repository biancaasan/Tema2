package ro.mta.facc.selab.weatherapp.model;


/*the Model class represents the entity weather and set or get the characteristics*/

public class Model{
    private String city;
    private String country;
    private int temperature;
    private double minTemperature;
    private double maxTemperature;
    private double windSpeed;
    private int humidity;
    private int pressure;
    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    private double longitude;

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    private String cloudiness;

    public Model() {
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getLongitude() {
        return longitude;
    }

    public Model(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setCloudiness(String cloudiness) {
        this.cloudiness = cloudiness;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getCity() {
        return city;
    }

    public int getPressure() {
        return pressure;
    }

    public String getCountry() {
        return country;
    }

    public String getCloudiness() {
        return cloudiness;
    }

}