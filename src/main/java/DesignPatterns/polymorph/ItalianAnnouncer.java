package DesignPatterns.polymorph;

/**
 * @author (created on 9/18/2017).
 */
public class ItalianAnnouncer implements Announcer {

    @Override
    public String announce(Birthday birthday) {
        return "Buon Compleanno!";
    }

    @Override
    public String announce(NewYears newYears) {
        return "Felice Anno Nuovo!";
    }
}

