package Java7.sort_algoritms;

/**
 * @author Evgenii_Lartcev (created on 11/3/2016).
 */
public class MergeSortMy {

    int[] arrForSorting;

    public MergeSortMy(int[] arrForSorting) {
        this.arrForSorting = arrForSorting;
    }

    public int[] getArrForSorting() {
        return arrForSorting;
    }

    public void mergeSort() {
        int[] arr_as_workspace = new int[arrForSorting.length];
        recMergeSort(arr_as_workspace, 0, arrForSorting.length - 1);
    }

    private void recMergeSort(int[] arr_as_workspace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) return;
        else {
            int middle = (lowerBound + upperBound) / 2;
            recMergeSort(arr_as_workspace, lowerBound, middle); //for lower-side of an array
            recMergeSort(arr_as_workspace, middle + 1, upperBound); //for upper-side of an array
            merge(arr_as_workspace, lowerBound, middle + 1, upperBound);
        }
    }

    private void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;                             // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;       // # of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (arrForSorting[lowPtr] < arrForSorting[highPtr])
                workSpace[j++] = arrForSorting[lowPtr++];
            else
                workSpace[j++] = arrForSorting[highPtr++];

        while (lowPtr <= mid)
            workSpace[j++] = arrForSorting[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = arrForSorting[highPtr++];

        for (j = 0; j < n; j++)
            arrForSorting[lowerBound + j] = workSpace[j];
    }  // end merge()
}
