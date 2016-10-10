package Java7.ADT;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgenii_Lartcev (created on 10/10/2016).
 */
public class CheckParenthesisTest {
    @Test
    public void check() throws Exception {
        String input1 = "c[d]";
        assertTrue(CheckParenthesis.check(input1));
    }

}