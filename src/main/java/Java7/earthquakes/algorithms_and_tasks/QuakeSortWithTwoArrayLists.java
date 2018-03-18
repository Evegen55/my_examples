package Java7.earthquakes.algorithms_and_tasks;

import Java7.earthquakes.EarthQuakeParser;
import Java7.earthquakes.model.QuakeEntry;

import java.util.ArrayList;
import java.util.List;

import static Java7.earthquakes.apps.EarthQuakeClient2.dumpCSV;

/**
 * @author Evegen
 */
public class QuakeSortWithTwoArrayLists {
    // This is the code from the Video of Selection Sort with Two ArrayLists

    /**
     *
     */

    public QuakeSortWithTwoArrayLists() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param quakes
     * @return
     */
    public QuakeEntry getSmallestMagnitude(List<QuakeEntry> quakes) {
        QuakeEntry min = quakes.get(0);
        for (QuakeEntry q : quakes) {
            if (q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        return min;
    }

    /**
     * @param in
     * @return
     */
    public ArrayList<QuakeEntry> sortByMagnitude(List<QuakeEntry> in) {
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        while (!in.isEmpty()) {
            QuakeEntry minElement = getSmallestMagnitude(in);
            in.remove(minElement);
            out.add(minElement);
        }
        return out;
    }

    /**
     *
     */
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        List<QuakeEntry> list = parser.readAndParseXMLFrom(source);

        System.out.println("readAndParseXMLFrom data for " + list.size() + " quakes");
        list = sortByMagnitude(list);

        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

    }

    /**
     *
     */
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        // String source = "data/nov20quakedatasmall.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        List<QuakeEntry> list = parser.readAndParseXMLFrom(source);
        dumpCSV(list);
        System.out.println("# quakes readAndParseXMLFrom: " + list.size());
    }


}
