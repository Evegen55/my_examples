package Java7.earthquakes;

import Java7.earthquakes.model.QuakeEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Java7.earthquakes.apps.EarthQuakeClient.SOURCE_PAST_WEEK;

/**
 * @author (created on 9/21/2017).
 */
public class EarthQuakeParserTest {

    @Test
    public void read(){
        String source = "data/2.5_week.atom";
        List<QuakeEntry> list = EarthQuakeParser.readAndParseXMLFrom(SOURCE_PAST_WEEK);
        Collections.sort(list);
        for (QuakeEntry loc : list) {
            System.out.println(loc);
        }
        System.out.println("# quakes = " + list.size());
    }

}