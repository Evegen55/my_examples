package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public class NewYears implements Event {
    @Override
    public void announce(Announcer announcer) {
        announcer.announce(this);
    }
}
