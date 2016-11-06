package Algorithms;

/**
 * Created by Evegen on 06.11.2016.
 */
public class UnionFind {
    int[] arrayConnected = {1,2,6,9};

    public int find (int arrayMember) {
        int mid = arrayConnected[0];
        for (int i = 0; i < arrayConnected.length; i++) {
            if (arrayConnected[i] == arrayMember) {
                //find max
                for (int k = 0; k < arrayConnected.length; k++) {
                    if (arrayConnected[k] >= mid) {
                        mid = arrayConnected[k];
                    }
                }

                break;
            }

        }
        return mid;
    }


}
