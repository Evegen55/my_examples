package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public class HappyNewYearInEnglishComposer extends Composer {

    private static final Event event = new NewYears();
    private static final Announcer announcer = new EnglishAnnouncer();

    public HappyNewYearInEnglishComposer() {
        super.event = event;
        super.announcer = announcer;
    }
}
