package Algorithms;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Evegen on 06.11.2016.
 */
public class SuccessorOfXTest {

    private final int[] arrBeforeSort = {77, 99, 44, 55, 22, 88, 11};

    @Test
    @Ignore
    public void getMainArray() throws Exception {
        SuccessorOfX successorOfX = new SuccessorOfX(10);
        System.out.println(Arrays.toString(successorOfX.getMainArray()));
    }

    @Test
    public void test1() throws Exception {
        SuccessorOfX successorOfX = new SuccessorOfX(arrBeforeSort);
        assertTrue(successorOfX.findSuccessor(31) == 44);
    }

}