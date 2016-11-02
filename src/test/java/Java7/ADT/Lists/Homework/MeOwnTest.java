package Java7.ADT.Lists.Homework;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MeOwnTest {

    private MyLinkedList<String> myOwnList;

    @Before
    public void setUp() {
        myOwnList = new MyLinkedList<>();
        myOwnList.add("String#0");
        myOwnList.add("String#1");
        myOwnList.add("String#2");
        myOwnList.add("String#3");
        myOwnList.add("String#4");
    }

    @Test
    public void testSizeAndIndex() {
        int indexOfTail = myOwnList.getTail().getIndexNode();
        int indexOfHead = myOwnList.getHead().getIndexNode();
        assertTrue(indexOfHead == 0);
        assertTrue(indexOfTail == 4);
        assertTrue(myOwnList.size() == 5);
        System.out.print("content of tail" + "\t" + myOwnList.getTail());
    }

    @Test
    public void testRecFindIndex() {
        for (int i = 0; i < myOwnList.size(); i++) {
            assertThat(myOwnList.recFindIndex(i, myOwnList.getTail()).getData(), is("String#" + i));
            assertTrue(myOwnList.recFindIndex(i, myOwnList.getTail()).getIndexNode() == i);
        }
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testExceptions1() {
        myOwnList.get(6);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testExceptions2() {
        myOwnList.get(-1);
    }

    @Test (expected = NullPointerException.class)
    public void testExceptions3() {
        myOwnList.add(null);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testExceptions4() {
        myOwnList.remove(-1);
    }

    @Test (expected = NullPointerException.class)
    public void testExceptions5() {
        myOwnList.set(2, null);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testExceptions6() {
        myOwnList.set(-1, "new string");
    }

}
