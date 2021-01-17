import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ro.mta.facc.selab.weatherapp.controller.WeatherRequest;
import ro.mta.facc.selab.weatherapp.model.Model;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class WeatherRequestTest {

    WeatherRequest myWheather= new WeatherRequest();

    @Mock
    Model myModel = Mockito.mock(Model.class);

    @Test
    void makeRequestTemperature() throws IOException {
        when(myModel.getTemperature()).thenReturn(17);
        when(myModel.getMinTemperature()).thenReturn(17.0);
        when(myModel.getMaxTemperature()).thenReturn(17.22);

        String city = "Venice";
        int temperature;
        double temperatureMin, temperatureMax;

        JSONObject obj = new JSONObject(myWheather.currentWeather(city));
        temperature= obj.getJSONObject("main").getInt("temp");
        temperatureMin= obj.getJSONObject("main").getInt("temp_min");
        temperatureMax= obj.getJSONObject("main").getInt("temp_max");

        assertEquals(temperature, 17);
        assertEquals(temperatureMin, 17.0);
        assertEquals(temperatureMax, 17.22);
    }

}
