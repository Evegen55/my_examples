package Java7.bubble_sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgenii_Lartcev (created on 10/5/2016).
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort;
    private static final int[] arrBeforeSort          = {77, 99, 44, 55, 22, 88, 11};
    private static final int[] arrAfterFirstIteration = {77, 44, 55, 22, 88, 11, 99};
    private static final int[] arrAfterFullSorting    = {11, 22, 44, 55, 77, 88, 99};

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort(arrBeforeSort);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("==============================");
        for (int i = 0; i < bubbleSort.getArr().length; i++) {
            System.out.println(bubbleSort.getArr()[i]);
        }
        bubbleSort = null;
    }

    @Test
    public void bubbleSortFirstIteration() throws Exception {
        bubbleSort.bubbleSortFirstIteration();
        assertThat(bubbleSort.getArr(), is(arrAfterFirstIteration));
    }

    @Test
    public void testBubbleSort() {
        bubbleSort.bubbleSortAll();
        assertThat(bubbleSort.getArr(), is(arrAfterFullSorting));
    }

}