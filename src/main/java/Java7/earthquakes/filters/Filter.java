package Java7.earthquakes.filters;


import Java7.earthquakes.QuakeEntry;

/**
 * Write a description of interface Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Filter {

    /**
     * @param quakeEntry
     * @return
     */
    boolean satisfies(QuakeEntry quakeEntry);

    /**
     * @return name of a filter
     */
    String getName();
}
