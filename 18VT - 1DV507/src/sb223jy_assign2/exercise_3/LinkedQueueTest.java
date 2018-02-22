package sb223jy_assign2.exercise_3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import sb223jy_assign2.exercise_1.LinkedQueue;
import sb223jy_assign2.exercise_1.Queue;

class LinkedQueueTest {

    @Test
    void testIsEmptySize() {
        Queue q = build(0);
        assertEquals(0, q.size());

        q.enqueue(1);
        assertEquals(1, q.size());

        q.dequeue();
        assertEquals(0, q.size());

        q = build(10);
        assertEquals(10, q.size());

        q = build(0);
        assertTrue(q.isEmpty());

        q = build(1);
        assertFalse(q.isEmpty());
    }

    @Test
    void testEnqueue() {
        Queue q = build(5);
        String expectedQueue = "[1 2 3 4 5 6]";

        q.enqueue(6);
        assertEquals(expectedQueue, q.toString());
    }

    @Test
    void testDequeue() {
        Queue q = build(5);
        String expectedQueue = "[2 3 4 5]";

        q.dequeue();
        assertEquals(expectedQueue, q.toString());
    }

    @Test
    void testFirstLast() {
        Queue q = build(3);
        assertEquals(1, q.first());
        assertEquals(3, q.last());
    }

    private Queue build(int size) {
        Queue queue = new LinkedQueue();
        for (int i = 0; i < size; i++)
            queue.enqueue((i + 1));
        return queue;
    }
}
