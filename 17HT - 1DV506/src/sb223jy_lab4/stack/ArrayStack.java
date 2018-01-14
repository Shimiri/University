package sb223jy_lab4.stack;

import java.util.Iterator;

public class ArrayStack implements Stack{

    public final int CAPACITY = 100;
    private Object[] list;
    private int top;

    public ArrayStack (int capacity) {
        list = new Object[capacity];
        top = -1;
    }

    public ArrayStack() {
        list = new Object[CAPACITY];
        top = -1;
    }

    public void push(Object element) {
        if (size() == list.length)
            return;

        list[++top] = element;
    }

    public Object pop() {
        if (isEmpty())
            return null;

        Object data = list[top];
        list[top--] = null;
        return data;
    }

    public Object peek() {
        if (isEmpty())
            return null;
        return list[top];
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int i = -1;

            @Override
            public boolean hasNext() {
                return list[i + 1] != null;
            }

            @Override
            public Object next() {
                return list[++i];
            }
        };
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
