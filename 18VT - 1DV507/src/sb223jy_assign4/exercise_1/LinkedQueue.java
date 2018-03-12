package sb223jy_assign4.exercise_1;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
    private int size;
    private Node tail;
    private Node head;

    public LinkedQueue() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void enqueue(T element) {
        size++;
        if (isEmpty()) {
            head = new Node(element);
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        size--;
        Node n = head;
        head = head.next;
        return n.data;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NullPointerException("Head is null");
        }

        return head.data;
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NullPointerException("Tail is null");
        }

        return tail.data;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<>() {
            Node n = head;

            @Override
            public boolean hasNext() {
                return n != null;
            }

            @Override
            public T next() {
                T element = n.data;
                n = n.next;
                return element;
            }
        };
    }

    private class Node {
        Node next;
        T data;

        Node (T data) {
            this.data = data;
        }
    }
}
