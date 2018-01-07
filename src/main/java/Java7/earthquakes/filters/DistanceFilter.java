/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java7.earthquakes.filters;

import Java7.earthquakes.model.Location;
import Java7.earthquakes.model.QuakeEntry;

/**
 * @author Lartsev
 */
public class DistanceFilter implements Filter {

    private int maxDist;
    private Location loc;

    /**
     * @param max
     * @param locate
     */
    public DistanceFilter(int max, Location locate) {
        maxDist = max;
        loc = locate;
    }

    /**
     * @param quakeEntry
     * @return
     */
    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        return quakeEntry.getLocation().distanceTo(loc) <= maxDist;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "DistanceFilter";
    }
}
