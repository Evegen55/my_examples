package Java7.ADT;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgenii_Lartcev (created on 10/10/2016).
 */
public class CheckParenthesisTest {

    @Test
    public void check1() throws Exception {
        String input1 = "c[d]";
        assertTrue(CheckParenthesis.check(input1));
    }

    @Test
    public void check2() throws Exception {
        String input1 = "c[d";
        assertFalse(CheckParenthesis.check(input1));
    }

    @Test
    public void check3() throws Exception {
        String input1 = "a{b[c]d}e";
        assertTrue(CheckParenthesis.check(input1));
    }

    @Test
    public void check4() throws Exception {
        String input1 = "a{b(c]d}e";
        assertFalse(CheckParenthesis.check(input1));
    }

}