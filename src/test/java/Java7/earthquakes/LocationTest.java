package Java7.earthquakes;

import org.junit.Before;
import org.junit.Test;

import static Java7.earthquakes.Location.*;
import static org.junit.Assert.*;

/**
 * @author (created on 9/22/2017).
 */
public class LocationTest {

    private Location denver;
    private Location billund;

    private final static double coordinateLatitudeDenver = 39.7392;
    private final static double coordinateLongitudeDenver = -104.9903;

    @Before
    public void test() {
        denver = new Location(coordinateLatitudeDenver, coordinateLongitudeDenver);
        billund = new Location(55.7308, 9.1153);
    }

    @Test
    public void set() throws Exception {
        denver.set(billund);
        assertEquals(denver, billund);
    }

    @Test
    public void reset() throws Exception {
        denver.set(billund);
        assertEquals(denver, billund);
        denver.resetToZero();
        assertNotEquals(denver, billund);
        assertEquals(denver, new Location(0, 0));
    }

    @Test
    public void convert() throws Exception {
        String convert = Location.convert(coordinateLatitudeDenver, FORMAT_DEGREES);
        assertEquals("39.7392", convert);
        convert = Location.convert(coordinateLatitudeDenver, FORMAT_MINUTES);
        assertEquals("39:44.352", convert);
        convert = Location.convert(coordinateLatitudeDenver, FORMAT_SECONDS);
        assertEquals("39:44:21.12", convert);
    }

    @Test
    public void convertToDouble() throws Exception {
        final double convert = Location.convert("39:44:21.12");
        final double convert2 = Location.convert("39.7392");
        final double convert3 = Location.convert("39.7392");
        assertTrue(convert == coordinateLatitudeDenver
                && convert2 == coordinateLatitudeDenver
                && convert3 == coordinateLatitudeDenver);
    }

    @Test
    public void distanceBetween() throws Exception {
    }

    @Test
    public void distanceTo() throws Exception {
    }

    @Test
    public void bearingTo() throws Exception {
    }

    @Test
    public void getProvider() throws Exception {
    }

    @Test
    public void setProvider() throws Exception {
    }

    @Test
    public void getTime() throws Exception {
    }

    @Test
    public void setTime() throws Exception {
    }

    @Test
    public void getElapsedRealtimeNanos() throws Exception {
    }

    @Test
    public void setElapsedRealtimeNanos() throws Exception {
    }

    @Test
    public void getLatitude() throws Exception {
    }

    @Test
    public void setLatitude() throws Exception {
    }

    @Test
    public void getLongitude() throws Exception {
    }

    @Test
    public void setLongitude() throws Exception {
    }

    @Test
    public void hasAltitude() throws Exception {
    }

    @Test
    public void getAltitude() throws Exception {
    }

    @Test
    public void setAltitude() throws Exception {
    }

    @Test
    public void removeAltitude() throws Exception {
    }

    @Test
    public void hasSpeed() throws Exception {
    }

    @Test
    public void getSpeed() throws Exception {
    }

    @Test
    public void setSpeed() throws Exception {
    }

    @Test
    public void removeSpeed() throws Exception {
    }

    @Test
    public void hasBearing() throws Exception {
    }

    @Test
    public void getBearing() throws Exception {
    }

    @Test
    public void setBearing() throws Exception {
    }

    @Test
    public void removeBearing() throws Exception {
    }

    @Test
    public void hasAccuracy() throws Exception {
    }

    @Test
    public void getAccuracy() throws Exception {
    }

    @Test
    public void setAccuracy() throws Exception {
    }

    @Test
    public void removeAccuracy() throws Exception {
    }

}