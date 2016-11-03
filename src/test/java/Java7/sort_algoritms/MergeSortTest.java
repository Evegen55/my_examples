package Java7.sort_algoritms;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgenii_Lartcev (created on 11/3/2016).
 */
public class MergeSortTest {

    private final int[] arrBeforeSort = {77, 99, 44, 55, 22, 88, 11, 100};
    private final int[] arrAfterFullSorting = {11, 22, 44, 55, 77, 88, 99, 100};

    @Test
    public void mergeSort() throws Exception {
        assertThat(MergeSort.mergeSort(arrBeforeSort), is(arrAfterFullSorting));
    }

}