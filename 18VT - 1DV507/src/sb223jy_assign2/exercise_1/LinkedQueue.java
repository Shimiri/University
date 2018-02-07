package sb223jy_assign2.exercise_1;

import java.util.Iterator;

/**
 * Queue interface implemented using a linked list.
 *
 * @author Samuel Bäckström
 */
public class LinkedQueue implements Queue {
    private int size;

    private Node head;
    private Node tail;

    /**
     * Constructor taking no parameters.
     */
    public LinkedQueue() {

    }

    /**
     * Checks whether the queue is empty or not.
     * @return Boolean value that shows if the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Enqueue an element of type Object, this element will be put last in the queue.
     * @param element The element to be stored in the queue.
     */
    @Override
    public void enqueue(Object element) {
        size++;
        if (isEmpty()) {
            head = new Node(element);
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
    }

    /**
     * Retrieve the first element in the queue.
     * @return The first element of type Object.
     */
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        size--;
        Node n = head;
        head = head.next;
        return n.element;
    }

    /**
     * @return The first element in the queue.
     */
    @Override
    public Object first() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return head.element;
    }

    /**
     * @return The last element in the queue.
     */
    @Override
    public Object last() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return tail.element;
    }

    /**
     * @return Returns an iterator for iterating over the queue.
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator<>() {
            Node n = head;

            @Override
            public boolean hasNext() {
                return n != null;
            }

            @Override
            public Object next() {
                Object element = n.element;
                n = n.next;
                return element;
            }
        };
    }


    @Override
    public int size() {
        return size;
    }

    /**
     * @return Returns a string representation of the queue.
     */
    public String toString() {
        if (isEmpty())
            return "Queue is empty";
        else {
            StringBuilder sb = new StringBuilder();
            Node n = head;
            do {
                sb.append(n.element).append(" ");
                n = n.next;
            } while (n != null);
            return "[" + sb.toString().substring(0, sb.length() - 1) + "]";
        }
    }

    private class Node {
        /**
         * The Next.
         */
        public Node next;
        /**
         * The Element.
         */
        public Object element;

        /**
         * Instantiates a new Node.
         *
         * @param element the element
         */
        public Node(Object element) {
            this.element = element;
        }
    }
}
