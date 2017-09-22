package Java7.earthquakes.filters;


import Java7.earthquakes.model.QuakeEntry;

/**
 * Write a description of class MinMaxFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinMagFilter implements Filter {

    private double magMin;

    /**
     * @param min
     */
    public MinMagFilter(double min) {
        magMin = min;
    }

    /**
     * @param quakeEntry
     * @return
     */
    public boolean satisfies(final QuakeEntry quakeEntry) {
        return quakeEntry.getMagnitude() >= magMin;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "MinMagFilter";
    }

}
