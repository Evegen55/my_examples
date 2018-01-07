package DesignPatterns.my;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author (created on 9/8/2017).
 */
public class SimpleClassTest {
    @Test
    public void doSmthWith() throws Exception {
        SimpleInterface simpleClass = new SimpleClass();
        simpleClass.doSmthWith("def");
    }

}