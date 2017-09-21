package Java7.earthquakes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static Java7.earthquakes.EarthQuakeClient.SOURCE_PAST_WEEK;
import static org.junit.Assert.*;

/**
 * @author (created on 9/21/2017).
 */
public class EarthQuakeParserTest {
    
    @Test
    public void read() throws Exception {
        String source = "data/2.5_week.atom";
        ArrayList<QuakeEntry> list = EarthQuakeParser.read(SOURCE_PAST_WEEK);
        Collections.sort(list);
        for (QuakeEntry loc : list) {
            System.out.println(loc);
        }
        System.out.println("# quakes = " + list.size());
    }

}