package Java7.earthquakes.model;

/**
 * @author Lartsev
 */
public class QuakeEntry implements Comparable<QuakeEntry> {

    private Location myLocation;
    private String title;
    private double depth;
    private double magnitude;

    /**
     * @param latitude
     * @param longitude
     * @param magnitude
     * @param title
     * @param depth
     */
    public QuakeEntry(double latitude, double longitude, double magnitude,
                      String title, double depth) {
        this.myLocation = new Location(latitude, longitude);
        this.magnitude = magnitude;
        this.title = title;
        this.depth = depth;
    }

    /**
     * @return
     */
    public Location getLocation() {
        return myLocation;
    }

    /**
     * @return
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * @return
     */
    public String getInfo() {
        return title;
    }

    /**
     * @return
     */
    public double getDepth() {
        return depth;
    }

    /**
     * @param loc
     * @return
     */
    @Override
    public int compareTo(final QuakeEntry loc) {
        double difflat = myLocation.getLatitude() - loc.myLocation.getLatitude();
        if (Math.abs(difflat) < 0.001) {
            double diff = myLocation.getLongitude() - loc.myLocation.getLongitude();
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            return 0;
        }
        if (difflat < 0) return -1;
        if (difflat > 0) return 1;

        // never reached
        return 0;
    }

    /**
     * @return
     */
    public String toString() {
        return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s",
                myLocation.getLatitude(),
                myLocation.getLongitude(),
                magnitude,
                depth,
                title);
    }

}