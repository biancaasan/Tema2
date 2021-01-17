import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import ro.mta.facc.selab.weatherapp.controller.DataFromFile;

public class DataFromFileTest {
    @Rule
    public DataFromFile res = new DataFromFile();

    @Test
    public void test() throws Exception
    {
        assertTrue("Read the countries from file", res.readCountries().size() > 0);
        assertTrue("Read the cities from file", res.readCities().size() > 0);
    }
}