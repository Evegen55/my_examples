package Java7.binary_search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Evgenii_Lartcev on 8/10/2016.
 */
public class BinarySearchByMeTest {
    @Test
    public void find() throws Exception {

    }

    BinarySearchByMe bs;
    long f;

    public BinarySearchByMeTest() {
    }

    @Before
    public void setUp() {
        long[] a = {9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117, 126, 135, 144};
        f = 27;
        bs = new BinarySearchByMe(a);
    }

    /**
     * Test of find method, of class BinarySearchByMe.
     */
    @Test
    public void testFind() {
        int expResult = bs.find(f);
        int result = 2;
        System.out.println("Find at position " + expResult);
        assertEquals(expResult, result);
    }
}