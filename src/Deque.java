import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;

    private int size;

    public Deque() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void addLast(Item item) {
        validateItem(item);
        ++size;

        if (head == null) {
            head = new Node<>(item, null, tail);
            if (tail == null) tail = head;
            return;
        }

        Node<Item> oldHead = head;
        head = new Node<>(item, null, oldHead);
        oldHead.prev = head;
    }

    public void addFirst(Item item) {
        validateItem(item);
        if (head == null) {
            addLast(item);
            return;
        }

        Node<Item> oldTail = tail;
        tail = new Node<>(item, tail, null);
        if (oldTail != null) oldTail.next = tail;

        ++size;
    }

    public Item removeLast() {
        validateSize();

        Item item = head.item;
        head = head.next;
        if (head != null) head.prev = null;

        --size;

        if (isEmpty()) tail = null;

        return item;
    }

    public Item removeFirst() {
        validateSize();

        Item item = tail.item;
        tail = tail.prev;
        if (tail != null) tail.next = null;

        --size;
        if (isEmpty()) head = null;

        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private void validateItem(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    private void validateSize() {
        if (size() < 1) throw new NoSuchElementException();
    }

    private class Node<Item> {

        Node<Item> prev;
        Node<Item> next;

        Item item;

        Node() {
           prev = null;
           next = null;
           item = null;
        }

        Node(Item item, Node<Item> prev, Node<Item> next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> iter = tail;

        @Override
        public boolean hasNext() {
            return iter != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Node<Item> next = iter;
            iter = iter.prev;
            return next.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}