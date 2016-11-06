package Algorithms;

/**
 * Created by Evegen on 06.11.2016.
 */
public class UnionFind {
    int[] arrayConnected = {1, 2, 6, 9};

    /**
     * Union-find with specific canonical element. Add a method find() to the union-find data type
     * so that find(i) returns the largest element in the connected component containing i.
     * The operations, union(), connected(), and find() should all take logarithmic time or better.
     * For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9
     * for each of the four elements in the connected components.
     *
     * @param arrayMember
     * @return
     */
    public int find(int arrayMember) {
        int mid = arrayConnected[0];
        boolean flag = false;
        for (int i = 0; i < arrayConnected.length; i++) {
            if (arrayConnected[i] >= mid) mid = arrayConnected[i];
            if (arrayConnected[i] == arrayMember) flag = true;
        }
        if (flag) return mid;
        return 0;
    }

}
