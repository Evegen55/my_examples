package Java7.ADT.Lists.Homework;

import java.util.Iterator;

/**
 * @author Evgenii_Lartcev (created on 10/24/2016).
 */
public class LinkedListByZaal<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }


    public void add(T t) {
        Node<T> node = new Node<T>(t, null);

        if (first != null) {
            first.next = node;
        }

        if (last != null) {
            last.next = node;
        }
        last = node;

    }
}
