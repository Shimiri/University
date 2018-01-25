package sb223jy_assign1.exercise_1;

import sb223jy_assign1.exercise_1.da1031.AbstractIntCollection;
import sb223jy_assign1.exercise_1.da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList {
    private int capacity;

    public ArrayIntList() {
        capacity = values.length;
    }

    public ArrayIntList(int capacity) {
        values = new int[capacity];
        this.capacity = capacity;
    }

    @Override
    public void add(int n) {
        checkCapacity();
        values[size++] = n;
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, size())) {
            values[index] = n;
        }
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, size())) {
            values[index] = 0;
        } else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, size())) {
            return values[index];
        } else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(int n) {
        for (int i = 0; i < values.length; i++) {
            if (n == values[i])
                return i;
        }
        System.out.println(n + " is not contained in list.");
        return -1;
    }

    private void checkCapacity() {
        if ((size() + 1) > capacity) {
            resize();
            capacity = values.length;
        }
    }
}
