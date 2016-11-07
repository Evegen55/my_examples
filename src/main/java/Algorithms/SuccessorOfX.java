package Algorithms;

import java.util.Random;

/**
 * Created by Evegen on 06.11.2016.
 * Under course taken on a www.coursera.org/learn/introduction-to-algorithms
 */
public class SuccessorOfX {
    private final int[] mainArray;

    public SuccessorOfX(int size) {
        mainArray = new int[size];
        for (int i = 0; i < size; i++) {
            //mainArray[i] = new Random(100).nextInt();
            mainArray[i] = i;
        }
    }

    public SuccessorOfX(int[] mainArray) {
        this.mainArray = mainArray;
    }

    public int[] getMainArray() {
        return mainArray;
    }

    /**
     * Successor with delete. Given a set of N integers S={0,1,...,N−1} and a sequence of requests of the following form:
     * Remove x from S
     * Find the successor of x: the smallest y in S such that y>=x.
     * design a data type so that all operations (except construction) should take logarithmic time or better.
     *
     * @param x
     * @return
     */
    public int findSuccessor(int x) {
        int findedMin = mainArray[0];

        for (int i = 0; i < mainArray.length; i++) {
            if (mainArray[i] == x) return x;
            if ((mainArray[i] > x) && mainArray[i] < findedMin) {
                findedMin = mainArray[i];
            }
        }
        return findedMin;
    }
}
