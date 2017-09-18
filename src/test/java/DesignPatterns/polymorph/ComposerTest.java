package DesignPatterns.polymorph;

import org.junit.Test;

/**
 * @author (created on 9/18/2017).
 */
public class ComposerTest {
    @Test
    public void test(){
        Composer composer = new Composer();
        Announcer announcer = composer.getAnnouncer();
        Event event = composer.getEvent();
        event.announce(announcer);
    }

}