package assignment2.exercise1;

import java.util.Arrays;

public class HashTable<T> implements A2HashTable<T> {
    private final double MAX_LOAD;
    private int threshold;
    private int numberOfElements;
    private int size;
    private int exp = 3;
    private T[] table;

    public HashTable() {
        MAX_LOAD = 1.0;
        initiateTable();
    }

    @SuppressWarnings("unchecked cast")
    private void initiateTable() {
        table = (T[]) new Object[(int) Math.pow(2, exp)];
        computeMaxThreshold();
    }

    private void computeMaxThreshold() {
        threshold = (int) (size * MAX_LOAD);
    }

    @Override
    public void insert(T element) {
        if (isFull())
            resize();

        int key = getKeyHash(element) % size;

        int x = 0;
        while (table[key] != null)
            key = (getKeyHash(element) + probe(x++)) % size;

        table[key] = element;
        incNumberOfElements();
    }

    @Override
    public void delete(T element) {
        int key = lookUpKey(element);
        if (key == Integer.MIN_VALUE)
            return;

        table[key] = null;
        decNumberOfElements();
    }

    @Override
    public boolean contains(T element) {
        return lookUpKey(element) != Integer.MIN_VALUE;
    }

    private int lookUpKey(T element) {
        T value;
        int x = 0;
        do {
            int currentKey = (getKeyHash(element) + probe(x++)) % size;
            value = table[currentKey];
            if (value != null && value.equals(element))
                return currentKey;
        } while (x <= size);
        return Integer.MIN_VALUE;
    }

    private int probe(int x) {
        return (int) ((Math.pow(x, 2) + x) / 2);
    }

    @Override
    public int getLengthOfArray() {
        return size;
    }

    @SuppressWarnings("unchecked cast")
    private void resize() {
        size = (int) Math.pow(2, exp);
        exp++;
        numberOfElements = 0;
        computeMaxThreshold();

        T[] oldTable = table;
        table = (T[]) new Object[size];

        for (T e : oldTable)
            if (e != null)
                insert(e);
    }

    private boolean isFull() {
        return numberOfElements == threshold;
    }

    private void incNumberOfElements() {
        numberOfElements++;
    }

    private void decNumberOfElements() {
        numberOfElements--;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    private int getKeyHash(T element) {
        return Math.abs(element.hashCode());
    }

    public void printTable() {
        System.out.println(Arrays.toString(table));
    }
}
