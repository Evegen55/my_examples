package frameworks_examples;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
}
