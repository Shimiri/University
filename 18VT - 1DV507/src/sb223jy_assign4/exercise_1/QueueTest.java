package sb223jy_assign4.exercise_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private LinkedQueue<Integer> q;
    private LinkedQueue<String> s;

    @BeforeEach
    public void setup() {
        q = new LinkedQueue<>();
        s = new LinkedQueue<>();
    }

    @Test
    public void shouldEnqueueItems() {
        q.enqueue(-1);
        q.enqueue(Integer.MAX_VALUE);
        q.enqueue(Integer.MIN_VALUE);
        q.enqueue(1);
        q.enqueue(0);

        assertEquals(5, q.size());

        s.enqueue("Hello");
        s.enqueue("1");
        s.enqueue("Hey");

        assertEquals(3, s.size());
    }

    @Test
    public void shouldDequeueItems() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        int i = q.dequeue();
        int j = q.dequeue();
        assertEquals(1, i);
        assertEquals(2, j);
        assertEquals(1, q.size());

        s.enqueue("Hello");
        s.enqueue("1");
        s.enqueue("Hey");

        String s1 = s.dequeue();
        String s2 = s.dequeue();
        assertEquals("Hello", s1);
        assertEquals("1", s2);
        assertEquals(1, q.size());
    }

    @Test
    public void shouldThrowExceptionOnEnqueue() {
        q = null;
        assertThrows(NullPointerException.class, () -> q.enqueue(1));
    }

    @Test
    public void shouldThrowExceptionOnDequeue() {
        q = null;
        assertThrows(NullPointerException.class, () -> q.dequeue());
    }

    @Test
    public void shouldReturnFirstItem() {
        q.enqueue(1);
        q.enqueue(2);

        assertEquals(1, (int) q.first());
    }

    @Test
    public void shouldReturnLastItem() {
        q.enqueue(1);
        q.enqueue(2);

        assertEquals(2, (int) q.last());
    }

    @Test
    public void shouldThrowExceptionOnFirstItem() {
        q = null;
        assertThrows(NullPointerException.class, () -> q.first());
    }

    @Test
    public void shouldThrowExceptionOnLastItem() {
        q = null;
        assertThrows(NullPointerException.class, () -> q.last());
    }

    @Test
    public void shouldReturnTrueIsEmpty() {
        assertEquals(true, q.isEmpty());
    }

    @Test
    public void shouldReturnFalseIsEmpty() {
        q.enqueue(1);
        assertEquals(false, q.isEmpty());
    }

    @Test
    public void shouldReturnCorrectSize() {
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();

        assertEquals(1, q.size());
    }

    @Test
    public void shouldIterateAllItems() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        Iterator it = q.iterator();

        StringBuilder sb = new StringBuilder();
        while (it.hasNext())
            sb.append(it.next()).append(" ");

        assertEquals("1 2 3 ", sb.toString());

        s.enqueue("Hello");
        s.enqueue("1");
        s.enqueue("Hey");

        Iterator itStr = s.iterator();

        StringBuilder sbStr = new StringBuilder();
        while (itStr.hasNext())
            sbStr.append(itStr.next()).append(" ");

        assertEquals("Hello 1 Hey ", sbStr.toString());
    }
}
