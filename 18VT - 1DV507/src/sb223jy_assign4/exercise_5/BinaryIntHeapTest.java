package sb223jy_assign4.exercise_5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryIntHeapTest {
    BinaryIntHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new BinaryIntHeap();
    }

    @Test
    public void insertIntegers() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        assertEquals(3, heap.size());
    }

    @Test
    public void resizeAfterEightIntegersAdded() {
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        assertEquals(9, heap.size());
    }

    @Test
    public void pullHighestInteger() {
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        assertEquals(1, heap.pullHighest());
    }

    @Test
    public void heapIsEmpty() {
        assertTrue(heap.isEmpty());
    }

    @Test
    public void heapIsNotEmpty() {
        heap.insert(1);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void heapTreeIsCorrect() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        String expected = "[ 1 2 3 4 5 6 7 8 ]";
        assertEquals(expected, heap.toString());
    }
}
