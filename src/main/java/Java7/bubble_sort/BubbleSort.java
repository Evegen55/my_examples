package Java7.bubble_sort;

/**
 * @author Evgenii_Lartcev (created on 10/5/2016).
 */
public class BubbleSort {

    private int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void bubbleSortFirstIteration() {
        for (int i = 0; i < arr.length; i++) {
            if (((i + 1) < arr.length) && (arr[i] > arr[i + 1])) {
                swap(i, i + 1);
            }
        }
    }

    public void bubbleSortAll() {
        for (int outer = arr.length; outer > 0; outer--) {
            for (int inner = 0; inner < outer-1; inner++) {
                if (arr[inner] > arr[inner + 1]) {
                    swap(inner, inner + 1);
                }
            }
        }

    }

    private void swap(int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
