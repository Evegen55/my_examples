package Java7.ADT.Lists.Homework;

import java.util.AbstractList;
import java.util.Iterator;


/**
 * A class that implements a doubly linked list
 *
 * @param <E> The type of the elements stored in the list
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class MyLinkedList<E> extends AbstractList<E>  implements Iterable<E> {
    private LLNode<E> head;
    private LLNode<E> tail;
    private int size;

    private int indexOfNode = indexOf(tail);

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        head = new LLNode<E>(null);
        tail = new LLNode<E>(null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    public LLNode<E> getHead() {
        return head;
    }

    public void setHead(LLNode<E> head) {
        this.head = head;
    }

    public LLNode<E> getTail() {
        return tail;
    }

    public void setTail(LLNode<E> tail) {
        this.tail = tail;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Appends an element to the end of the list.
     * It depends on what type od data allows to store in a List
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Nulls not allowed");
        }
        tail = new LLNode<E>(element, tail);
        indexOfNode++;
        tail.setIndexNode(indexOfNode);
        tail.setData(element);
        size++;
        return true;
    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        LLNode<E> searchNode = recFindIndex(index, tail);
        if (size == 0) {
            throw new IndexOutOfBoundsException("Warning! You've just tried to get an object from empty list");
        }
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Warning! You've just tried to get an object out of bounds");
        }
        return searchNode.getData();
    }


    /**
     * Add an element to the list at the specified index
     *
     * @param index   where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        if (index < tail.getIndexNode()) {
            LLNode<E> searched = recFindIndex(index, this.tail);
            LLNode<E> beforeSearched = recFindIndex(index, this.tail).getPrev();
            LLNode<E> pastedNode = new LLNode<E>(element, beforeSearched);
            pastedNode.setIndexNode(index);
            pastedNode.setPrev(beforeSearched);
            pastedNode.setNext(searched);
            beforeSearched.setNext(pastedNode);
            searched.setPrev(pastedNode);
            size++;
            recAddIndexes(index, tail);
        } else if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Warning! You've just tried to add an object out of bounds");
        } else {
            add(element);
        }
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public E remove(int index) {
        recDecrIndexes(index + 1, tail);
        LLNode<E> deletedNode = recFindIndex(index, this.tail).getPrev();
        E deletedData = deletedNode.getData();
        LLNode<E> deletedNodeNext = deletedNode.getNext();
        LLNode<E> deletedNodePrev = deletedNode.getPrev();
        deletedNodeNext.setPrev(deletedNodePrev);
        deletedNodePrev.setNext(deletedNodeNext);
        size--;
        return deletedData;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        E deletedData;
        if (element == null) {
            throw new NullPointerException("Nulls not allowed");
        } else if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Warning! You've just tried to add an object out of bounds");
        } else {
            LLNode<E> settedNode = recFindIndex(index, this.tail);
            deletedData = settedNode.getData();
            settedNode.setData(element);
        }
        return deletedData;
    }

    //helper method for searching by index - search
    protected LLNode<E> recFindIndex(final int searchIndex, final LLNode<E> tailSearch) {
        if (searchIndex < 0 || searchIndex > tailSearch.getIndexNode() || tailSearch == null) {
            throw new IndexOutOfBoundsException("Warning! You've just tried to find null object");
        } else if (searchIndex == tailSearch.getIndexNode()) {
            return tailSearch;
        } else {
            return recFindIndex(searchIndex, tailSearch.getPrev());
        }
    }

    //helper method for addition indexes after addition an element at index
    private void recAddIndexes(final int edgeLeftIndex, final LLNode<E> tailSearch) {
        for (int i = tailSearch.getIndexNode(); i >= edgeLeftIndex; i--) {
            recFindIndex(i, tailSearch).incrementIndex();
        }
    }

    //helper method for addition indexes after addition an element at index
    private void recDecrIndexes(int edgeLeftIndex, LLNode<E> tailSearch) {
        for (int i = 0; i <= tailSearch.getIndexNode() - edgeLeftIndex; i++) {
            recFindIndex(edgeLeftIndex + i, tailSearch).decrementIndex();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LLNode<E> current = head.getNext().getNext(); //because head and tail are supply the ADT
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

}

////////////////////////////////////////////////////////////////////////////////

class LLNode<E> {
    private LLNode<E> prev;
    private LLNode<E> next;
    private E data;
    private int indexNode;

    public LLNode() {
        prev = null;
        next = null;
    }

    public LLNode(E e) {
        this();
        data = e;
    }

    public LLNode(E e, LLNode<E> prevNode) {
        data = e;
        //for SingleLinkedList
        this.next = prevNode.next;
        prevNode.next = this;
        //for DoublyLinkedList
        this.prev = prevNode;

    }

    public LLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(LLNode<E> prev) {
        this.prev = prev;
    }

    public LLNode<E> getNext() {
        return next;
    }

    public void setNext(LLNode<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getIndexNode() {
        return indexNode;
    }

    public void setIndexNode(int indexNode) {
        this.indexNode = indexNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LLNode<?> llNode = (LLNode<?>) o;

        if (indexNode != llNode.indexNode) return false;
        return getData() != null ? getData().equals(llNode.getData()) : llNode.getData() == null;

    }

    @Override
    public int hashCode() {
        int result = getData() != null ? getData().hashCode() : 0;
        result = 31 * result + indexNode;
        return result;
    }

    @Override
    public String toString() {
        String ret = null;
        if (prev != null & next != null) {
            ret = "LLNode{" +
                    "prev data = " + prev.getData() +
                    ", next data = " + next.getData() +
                    ", data = " + data +
                    ", indexNode = " + indexNode +
                    '}';
        } else if (prev == null) {
            ret = "LLNode{" +
                    "prev data = NULL" +
                    ", next data = " + next.getData() +
                    ", data = " + data +
                    ", indexNode = " + indexNode +
                    '}';
        }else if (next == null) {
            ret = "LLNode{" +
                    "prev data = " + prev.getData() +
                    ", next data = NULL" +
                    ", data =" + data +
                    ", indexNode = " + indexNode +
                    '}';
        }
        return ret;
    }

    void incrementIndex() {
        indexNode = indexNode + 1;
    }

    void decrementIndex() {
        indexNode = indexNode - 1;
    }
}

