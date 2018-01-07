package Java7.matrixes;

import static Java7.matrixes.CheckMatrix.*;

/**
 * @author Evgenn
 */
public class MatrixOperations {

    /**
     * @param firstArr
     * @param secondArr
     * @return
     */
    public static double[][] multiplyMatrix(final double firstArr[][], final double secondArr[][]) {
        final int lengthArr = getArrayCountRow(firstArr);
        final int heightArr = getArrayCountColumn(secondArr);
        final double multArr[][] = new double[lengthArr][heightArr];
        double countF = 0;
        double countS = 0;
        if (
                getArrayCountColumn(firstArr) == getArrayCountRow(secondArr) &&
                        isArraySquared(firstArr) &&
                        isArraySquared(secondArr)
                ) {
            for (int k = 0; k < getArrayCountRow(firstArr); k++) {
                for (int n = 0; n < getArrayCountColumn(firstArr); n++) {
                    for (int r = 0; r < getArrayCountColumn(firstArr); r++) {
                        for (int i = 0; i < getArrayCountColumn(firstArr); i++) {
                            countF = firstArr[k][r] * secondArr[r][n];
                            countS += countF;
                            break;
                        }
                        multArr[k][n] = countS;
                    }
                    countS = 0;
                }
            }
        }
        return multArr;
    }

    /**
     * @param firstArr
     * @param secondArr
     * @return
     */
    public static double[][] sumMatrix(final double firstArr[][], final double secondArr[][]) {
        final int lengthArr = getArrayCountRow(firstArr);
        final int HeightArr = getArrayCountColumn(firstArr);
        final double sumArr[][] = new double[lengthArr][HeightArr];
        if (checkArraysDimension(firstArr, secondArr)) {
            for (int i = 0; i < firstArr.length; i++) {
                for (int k = 0; k < firstArr[0].length; k++) {
                    sumArr[i][k] = firstArr[i][k] + secondArr[i][k];
                }
            }
        }
        return sumArr;
    }

}
