import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final double INCREASE_THRESHOLD = 0.75d;
    private static final double DECREASE_THRESHOLD = 0.25d;

    private Item[] items;

    private int size;

    public RandomizedQueue() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (isNeedIncreasement()) increaseArray();

        items[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        int index = StdRandom.uniform(size());
        Item dequeuedItem = items[index];
        items[index] = items[size - 1];
        items[this.size - 1] = null;
        size--;

        if (isNeedDecreasement()) decreaseArray();

        return dequeuedItem;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();

        return items[StdRandom.uniform(size())];
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private void increaseArray() {
        Item[] newArray = (Item[]) new Object[items.length * 2];
        for (int i = 0; i < size(); ++i) {
            newArray[i] = items[i];
            items[i] = null;
        }
        items = newArray;
    }

    private void decreaseArray() {
        Item[] newArray = (Item[]) new Object[(int)Math.floor(items.length * 0.25d)];
        for (int i = 0; i < size(); ++i) {
            newArray[i] = items[i];
            items[i] = null;
        }
        items = newArray;
    }

    private boolean isNeedIncreasement() {
        return size() > 1 && 1. * size() / items.length >= INCREASE_THRESHOLD;
    }

    private boolean isNeedDecreasement() {
        return size() > 1 && 1. * size() / items.length <= DECREASE_THRESHOLD;
    }

    private class RandomizedIterator implements Iterator<Item> {

            private Item[] array;
            private int size;

            RandomizedIterator() {
                array = (Item[]) new Object[items.length];
                this.size = size();
                for (int i = 0; i < size; ++i) array[i] = items[i];
            }

            @Override
            public boolean hasNext() {
                return this.size > 0;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();

                int index = StdRandom.uniform(this.size);
                Item dequeuedItem = this.array[index];
                this.array[index] = this.array[this.size - 1];
                this.array[this.size - 1] = null;
                this.size--;

                return dequeuedItem;
            }

    }

}
