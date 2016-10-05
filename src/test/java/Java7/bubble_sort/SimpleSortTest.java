package Java7.bubble_sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgenii_Lartcev (created on 10/5/2016).
 */
public class SimpleSortTest {


    private SimpleSort simpleSort;
    private final int[] arrBeforeSort = {77, 99, 44, 55, 22, 88, 11};
    private final int[] arrAfterFirstIteration = {77, 44, 55, 22, 88, 11, 99};
    private final int[] arrAfterFullSorting = {11, 22, 44, 55, 77, 88, 99};

    @Before
    public void setUp() throws Exception {
        simpleSort = new SimpleSort(arrBeforeSort);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("==============================");
        for (int i = 0; i < simpleSort.getArr().length; i++) {
            System.out.print(simpleSort.getArr()[i] + "\t");
        }
        System.out.println("\n");
    }

    @Test
    public void bubbleSortFirstIteration() throws Exception {
        simpleSort.bubbleSortFirstIteration();
        assertThat(simpleSort.getArr(), is(arrAfterFirstIteration));
    }

    @Test
    public void testBubbleSortAll() {
        simpleSort.bubbleSortAll();
        assertThat(simpleSort.getArr(), is(arrAfterFullSorting));
    }

    @Test
    public void selectionSort() {
        simpleSort.selectionSort();
        assertThat(simpleSort.getArr(), is(arrAfterFullSorting));
    }

}