package Algorithms.sort_algoritms;

/**
 * @author Evgenii_Lartcev (created on 11/3/2016).
 */
public class MergeSort {

    /**
     * This metod MAKES CHANGES INSIDE ARRAY
     *
     * @param basicArray
     * @return
     */
    public static int[] mergeSort(final int[] basicArray) {
        final int[] arr_as_workspace = new int[basicArray.length];
        recMergeSort(basicArray, arr_as_workspace, 0, basicArray.length - 1);
        return basicArray;  //sorted
    }

    private static void recMergeSort(final int[] basicArray,final  int[] arr_as_workspace,final  int lowerBound,final  int upperBound) {
        if (lowerBound == upperBound) return;
        else {
            final int middle = (lowerBound + upperBound) / 2;
            recMergeSort(basicArray, arr_as_workspace, lowerBound, middle); //for lower-side of an array
            recMergeSort(basicArray, arr_as_workspace, middle + 1, upperBound); //for upper-side of an array
            merge(basicArray, arr_as_workspace, lowerBound, middle + 1, upperBound);
        }
    }

    private static void merge(final int[] basicArray, final int[] workSpace, int lowPtr, int highPtr, final int upperBound) {
        final int lowerBound = lowPtr;
        final int mid = highPtr - 1;
        final int numberOfItems = upperBound - lowerBound + 1;
        int workspaceIndex = 0;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (basicArray[lowPtr] < basicArray[highPtr])
                workSpace[workspaceIndex++] = basicArray[lowPtr++];
            else
                workSpace[workspaceIndex++] = basicArray[highPtr++];
        }
        while (lowPtr <= mid) {
            workSpace[workspaceIndex++] = basicArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[workspaceIndex++] = basicArray[highPtr++];
        }
        for (workspaceIndex = 0; workspaceIndex < numberOfItems; workspaceIndex++) {
            basicArray[lowerBound + workspaceIndex] = workSpace[workspaceIndex];
        }
    }
}
