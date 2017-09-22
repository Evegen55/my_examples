package Java7.earthquakes;

import org.junit.Test;

import static Java7.earthquakes.algorithms_and_tasks.EarthQuakeClient.allQuakesRussia;
import static Java7.earthquakes.algorithms_and_tasks.EarthQuakeClient.quakesByPhrase;

/**
 * @author (created on 9/21/2017).
 */
public class EarthQuakeClientTest {

    @Test
    public void allQuaqesRussiaTest() throws Exception {
        allQuakesRussia();
    }

    @Test
    public void testQuakesByPhrase() {
        final String where = "end";
        final String phrase = "California";
        quakesByPhrase(where, phrase);
    }

}