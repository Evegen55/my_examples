package Java7.sort_algoritms;

/**
 * @author Evgenii_Lartcev (created on 10/5/2016). *
 */
public class BubbleSort {

    private int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    /**
     *
     */
    public void bubbleSortFirstIteration() {
        for (int i = 0; i < arr.length; i++) {
            if (((i + 1) < arr.length) && (arr[i] > arr[i + 1])) {
                swap(i, i + 1);
            }
        }
    }

    /**
     * O(N^2)
     */
    public void bubbleSortAll() {
        for (int outer = arr.length; outer > 0; outer--) {
            for (int inner = 0; inner < outer - 1; inner++) {
                if (arr[inner] > arr[inner + 1]) {
                    swap(inner, inner + 1);
                }
            }
        }

    }

    /**
     * O(N^2) - compares
     * O(N) - swap elements
     */
    public void selectionSort() {
        int min;
        for (int outer = 0; outer < arr.length - 1; outer++) {
            min = outer; //find minimum element
            for (int inner = outer + 1; inner < arr.length; inner++) {
                if (arr[inner] < arr[min]) {
                    min = inner; //if and oly if
                }
            }
            swap(outer, min);
        }
    }

    /**
     * O(N^2) - compares
     * O(N^2) - swap elements in the worst case
     * O(N) - swap elements in the best case
     */
    public void selectSort() {
        int inner;
        for (int outer = 0; outer < arr.length; outer++) {
            int temp = arr[outer];
            inner = outer;
            while (inner > 0 && arr[inner - 1] >= temp) {
                arr[inner] = arr[inner - 1];
                --inner;
            }
            arr[inner] = temp;
        }
    }

    private void swap(int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
