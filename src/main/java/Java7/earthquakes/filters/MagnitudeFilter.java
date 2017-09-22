/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java7.earthquakes.filters;

import Java7.earthquakes.model.QuakeEntry;

/**
 * @author Lartsev
 */
public class MagnitudeFilter implements Filter {

    private double minMag;
    private double maxMag;

    /**
     * @param min
     * @param max
     */
    public MagnitudeFilter(double min, double max) {
        this.minMag = min;
        this.maxMag = max;
    }

    /**
     * @param quakeEntry
     * @return
     */
    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        return quakeEntry.getMagnitude() >= minMag && quakeEntry.getMagnitude() <= maxMag;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "MagnitudeFilter";
    }

}
