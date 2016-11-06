package Algorithms;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Evegen on 06.11.2016.
 */
public class SuccessorOfXTest {
    @Test
    public void getMainArray() throws Exception {
        SuccessorOfX successorOfX = new SuccessorOfX(10);
        Stream.of(successorOfX).forEach(System.out::println);
    }

}