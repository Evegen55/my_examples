package DesignPatterns.polymorph;

import org.junit.After;
import org.junit.Test;

/**
 * @author (created on 9/18/2017).
 */
public class ComposerTest {

    private static Composer composer;
    private static Announcer announcer;
    private static Event event;

    @After
    public void afterTestsDoTheSame() {
        announcer = composer.getAnnouncer();
        event = composer.getEvent();
        event.announce(announcer);
    }

    @Test
    public void testHappyNewYearInEnglishComposer() {
        composer = new HappyNewYearInEnglishComposer();
    }

    @Test
    public void testHappyBirthdayInItalianComposer() {
        composer = new HappyBirthdayInItalianComposer();
    }


}