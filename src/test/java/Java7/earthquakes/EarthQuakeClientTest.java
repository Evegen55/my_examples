package Java7.earthquakes;

import org.junit.Test;

import static Java7.earthquakes.apps.EarthQuakeClient.allQuakesRussia;
import static Java7.earthquakes.apps.EarthQuakeClient.quakesByPhrase;

/**
 * @author (created on 9 / 21 / 2017).
 */
public class EarthQuakeClientTest {

    @Test
    public void allQuaqesRussiaTest() {
        allQuakesRussia();
    }

    @Test
    public void testQuakesByPhrase() {
        final String where = "end";
        final String phrase = "California";
        quakesByPhrase(where, phrase);
    }

}