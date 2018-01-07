package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public class EnglishAnnouncer implements Announcer {

    @Override
    public String announce(Birthday birthday) {
        return "Happy Birthday!";
    }

    @Override
    public String announce(NewYears newYears) {
        return "Happy New Years!";
    }
}
