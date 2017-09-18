package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public class Composer {

    Event eventBirthday = new Birthday();
//    Event eventNewYears = new NewYears();

    Announcer englishAnnouncer = new EnglishAnnouncer();
//    Announcer italianAnnouncer = new ItalianAnnouncer();

    public Event getEvent() {
        return eventBirthday;
    }

    public Announcer getAnnouncer() {
        return englishAnnouncer;
    }
}
