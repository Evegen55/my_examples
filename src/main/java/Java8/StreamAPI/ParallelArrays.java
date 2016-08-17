package Java8.StreamAPI;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Evgenii_Lartcev on 8/17/2016.
 * This small code snippet uses method parallelSetAll() to fill up arrays with 20000 random values.
 * After that, the parallelSort() is being applied. The program outputs first 10 elements before and after sorting
 * so to ensure the array is really ordered.
 */
public class ParallelArrays {
    public static void main( String[] args ) {
        long[] arrayOfLong = new long [ 20000000 ];
        Arrays.parallelSetAll( arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();
        final long startTime1 = System.nanoTime();
        Arrays.parallelSort( arrayOfLong );
        final long endTime1= System.nanoTime();

        final long startTime2 = System.nanoTime();
        Arrays.sort(arrayOfLong);
        final long endTime2= System.nanoTime();

        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();
        System.out.println();
        System.out.println("Arrays.parallelSort timing" + "\t" + ((endTime1-startTime1)/(Math.pow(10, 8))));
        System.out.println("Arrays.sort timing" + "\t" + ((endTime2-startTime2)/(Math.pow(10, 8))));
    }
}
