package frameworks_examples;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by Evgenii_Lartcev on 9/12/2016.
 */
public class MockitoHelloWorld {
    @Test
    public void iterator_will_return_hello_world() {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        String result = i.next()+" "+i.next();
        assertEquals("Hello World", result);
    }

    @Test
    public void with_arguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        assertEquals(1, c.compareTo("Test"));
    }

    @Test
    public void with_unspecified_arguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1, c.compareTo(5));
        assertEquals(-1, c.compareTo(10));
        assertEquals(-1, c.compareTo(13));
        assertEquals(-1, c.compareTo(27));
    }

    @Test(expected=IOException.class)
    public void OutputStreamWriter_rethrows_an_exception_from_OutputStream()
            throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        doThrow(new IOException()).when(mock).close();
        osw.close();
    }

    @Test
    public void OutputStreamWriter_Closes_OutputStream_on_Close()
            throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();
        verify(mock).close();
    }

    @Test
    public void testBehaviourMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        //good
        verify(mockedList).add("one");
        verify(mockedList).clear();
        //bad
        //verify(mockedList).add("two");
    }

    @Test
    public void testBehaviuorStub() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));
    }

    @Test
    public void testHalfMock() {
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");
    }



}
