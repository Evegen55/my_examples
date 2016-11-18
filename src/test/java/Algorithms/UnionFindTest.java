package Algorithms;

import Algorithms.ROBERT_SEDGEWICK.UnionFind;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Evegen on 06.11.2016.
 */
public class UnionFindTest {
    @Test
    public void find() throws Exception {
        UnionFind uf = new UnionFind();
        assertTrue(uf.find(1) == 9);
        assertEquals(uf.find(2),9);
        assertEquals(uf.find(6),9);
        assertEquals(uf.find(9),9);
    }

}