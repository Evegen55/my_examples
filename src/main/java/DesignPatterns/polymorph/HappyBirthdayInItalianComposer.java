package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public class HappyBirthdayInItalianComposer extends Composer {

    private static final Event event = new Birthday();
    private static final Announcer announcer = new ItalianAnnouncer();

    public HappyBirthdayInItalianComposer() {
        super.event = event;
        super.announcer = announcer;
    }
}
