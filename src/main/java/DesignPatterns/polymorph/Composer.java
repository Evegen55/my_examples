package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public abstract class Composer {

    protected Event event;
    protected Announcer announcer;

    public Event getEvent() {
        return event;
    }

    public Announcer getAnnouncer() {
        return announcer;
    }
}
