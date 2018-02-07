package sb223jy_assign2.exercise_1;

import java.util.Iterator;

public class QueueMain {
    public static void main(String[] args) {
        Queue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        linkedQueue.enqueue(5);
        linkedQueue.enqueue(6);
        linkedQueue.enqueue(7);
        linkedQueue.enqueue(8);
        linkedQueue.enqueue(9);
        linkedQueue.enqueue(10);

        System.out.println(linkedQueue);
        System.out.println("Queue size: " + linkedQueue.size() + "\n");

        linkedQueue.dequeue();
        linkedQueue.dequeue();
        linkedQueue.dequeue();
        linkedQueue.dequeue();

        System.out.println(linkedQueue);
        System.out.println("Queue size: " + linkedQueue.size() + "\n");

        Iterator<Object> it = linkedQueue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\nFirst element: " + linkedQueue.first() + "\nLast element: " + linkedQueue.last());
    }
}
