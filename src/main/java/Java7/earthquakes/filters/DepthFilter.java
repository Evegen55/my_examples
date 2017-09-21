/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java7.earthquakes.filters;

import Java7.earthquakes.QuakeEntry;

/**
 * @author Lartsev
 */
public class DepthFilter implements Filter {

    private double minDepth;
    private double maxDepth;

    /**
     * @param min
     * @param max
     */
    public DepthFilter(double min, double max) {
        this.minDepth = min;
        this.maxDepth = max;
    }

    /**
     * @param quakeEntry
     * @return
     */
    @Override
    public boolean satisfies(final QuakeEntry quakeEntry) {
        return quakeEntry.getDepth() > minDepth && quakeEntry.getDepth() < maxDepth;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "DepthFilter";
    }
}
