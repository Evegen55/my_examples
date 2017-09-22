package Java7.matrixes;

/**
 * @author Johnn
 */
public class CheckMatrix {

    /**
     * @param first is an array which has to be check for retangularity.     *
     * @return boolean
     */
    public static boolean isArraySquared(final double first[][]) {
        boolean checking = false;
        for (int i = 1; i < first.length; i++) {
            checking = first[i].length == first[i - 1].length;
        }
        return checking;
    }

    /**
     * @param first  is a first array which dimension has to be check and compare
     *               with other array. (проверка равенства размерности двух массивов)
     * @param second is a second array which has to be check and compare
     *               with other array.
     * @return boolean
     */
    public static boolean checkArraysDimension(final double first[][], final double second[][]) {
        boolean checking = false;
        if (isArraySquared(first) &&
                isArraySquared(second) &&
                first.length == second.length &&
                first[0].length == second[0].length &&
                getArrayCountColumn(first) != -1 &&
                getArrayCountRow(first) != -1
                ) {
            checking = true;
        }
        return checking;
    }

    /**
     * @param arrayToPrint is an array which has to be printed.
     */
    public static void printMatrixArray(final double arrayToPrint[][]) {
        if (isArraySquared(arrayToPrint)) {
            for (double[] printedArr1 : arrayToPrint) {
                for (int k = 0; k < arrayToPrint[0].length; k++) {
                    System.out.print(printedArr1[k] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is not rectangular");
        }
    }

    /**
     * @param matrixArrayNoName is an rectangular array which rows has to be counted     *
     * @return amount of rows
     */
    public static int getArrayCountRow(final double matrixArrayNoName[][]) {
        int i = 0;
        if (matrixArrayNoName.length <= 0) {
            i = -1;
        } else {
            i = matrixArrayNoName.length;
        }
        return i;
    }

    /**
     * @param matrixArrayNoName is an array which columns has to be counted
     *                          (метод возвращает количество столбцов)
     * @return amount of columns
     */
    public static int getArrayCountColumn(final double matrixArrayNoName[][]) {
        int i = 0;
        if (matrixArrayNoName.length <= 0 ||
                matrixArrayNoName[0].length <= 0 ||
                isArraySquared(matrixArrayNoName) == false) {
            i = -1;
        } else {
            i = matrixArrayNoName[0].length;
        }
        return i;
    }

    /**
     * Checks two matrices by width
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean checkArraysWidth(final double first[][], final double second[][]) {
        return getArrayCountColumn(first) == getArrayCountColumn(second);
    }
}

