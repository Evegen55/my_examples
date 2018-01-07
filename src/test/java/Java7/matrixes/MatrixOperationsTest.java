package Java7.matrixes;

import org.junit.Test;

import static Java7.matrixes.CheckMatrix.printMatrixArray;
import static Java7.matrixes.CheckMatrixTest.SECOND_SQUARED_ARRAY;
import static Java7.matrixes.CheckMatrixTest.SQUARED_ARRAY;
import static Java7.matrixes.MatrixOperations.sumMatrix;
import static org.junit.Assert.*;

/**
 * @author (created on 9/22/2017).
 */
public class MatrixOperationsTest {

    @Test
    public void multiplyMatrix() throws Exception {
    }

    @Test
    public void sumMatrixTest() throws Exception {
        printMatrixArray(sumMatrix(SQUARED_ARRAY, SECOND_SQUARED_ARRAY));
    }

}