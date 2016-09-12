import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotSame;

/**
 * Created by Evgenii_Lartcev on 9/12/2016 under
 * https://cnapagoda.blogspot.ru/2016/09/java-string-intern-method.html
 *
 */
public class StringIntern {

    @Test
    public void testIntern() {
        String name1 = "Value";
        String name2 = "Value";
        String name3 = new String("Value");
        String name4 = new String("Value").intern();

        assertThat(name1, is(name2));
        assertThat(name1, is(name4));
        assertNotSame(name1, is(name3));
        assertNotSame(name2, is(name3));
        assertNotSame(name2, is(name4));
        assertNotSame(name3, is(name4));
    }
}
