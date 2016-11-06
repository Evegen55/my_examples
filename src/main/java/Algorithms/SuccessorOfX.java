package Algorithms;

import java.util.Random;

/**
 * Created by Evegen on 06.11.2016.
 */
public class SuccessorOfX {
    private final int[] mainArray;

    public SuccessorOfX(int size) {
        mainArray = new int[size];
        for (int i = 0; i < size; i++) {
            mainArray[i] = new Random(100).nextInt();
        }
    }

    public SuccessorOfX(int[] mainArray) {
        this.mainArray = mainArray;
    }

    public int[] getMainArray() {
        return mainArray;
    }
}
