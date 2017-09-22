package Java7.earthquakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author (created on 9/22/2017).
 */
public class LocationTest {

    private Location denver;
    private Location billund;

    @Before
    public void test() {
        denver = new Location(39.7392, -104.9903);
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
    }

    @Test
    public void convert1() throws Exception {
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