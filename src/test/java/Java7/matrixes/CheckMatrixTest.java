package Java7.matrixes;

import org.junit.Test;

import static Java7.matrixes.CheckMatrix.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author (created on 9/22/2017).
 */
public class CheckMatrixTest {

    public static final double SQUARED_ARRAY[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    public static final double SECOND_SQUARED_ARRAY[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    public static final double TRIANGLED_ARRAY[][] = {{1}, {2, 3}, {4, 5, 6}};

    @Test
    public void isArraySquared() {
        assertTrue(CheckMatrix.isArraySquared(SQUARED_ARRAY));
    }

    @Test
    public void checkArraysDimensionTest() {
        assertTrue(checkArraysDimension(SQUARED_ARRAY, SECOND_SQUARED_ARRAY));
    }

    @Test
    public void printMatrixArrayTest() {
        printMatrixArray(TRIANGLED_ARRAY);
        System.out.println();
        printMatrixArray(SQUARED_ARRAY);
    }

    @Test
    public void getArrayCountRowTest() {
        assertTrue(getArrayCountRow(SQUARED_ARRAY) == SQUARED_ARRAY.length);
        assertTrue(getArrayCountRow(TRIANGLED_ARRAY) == TRIANGLED_ARRAY.length);
    }

    @Test
    public void getArrayCountColumnTest() {
        assertTrue(getArrayCountColumn(SQUARED_ARRAY) == SQUARED_ARRAY[0].length);
        assertTrue(getArrayCountColumn(TRIANGLED_ARRAY) == -1);
    }

    @Test
    public void checkArraysWidthTest() throws Exception {
        assertTrue(checkArraysWidth(SQUARED_ARRAY, SECOND_SQUARED_ARRAY));
        assertFalse(checkArraysWidth(SQUARED_ARRAY, TRIANGLED_ARRAY));
        assertFalse(checkArraysWidth(TRIANGLED_ARRAY, SQUARED_ARRAY));
    }

}