import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by avogel on 3/29/17.
 */
public class PriorityQueueTest {
    @Test
    public void testNewPriorityQueue() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testIsMinHeap() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertTrue(queue.isMinHeap(0));

        queue.insert("Charlie", 12);
        assertTrue(queue.isMinHeap(0));

        queue.insert("Jackson", 6);
        assertTrue(queue.isMinHeap(0));
    }


    @Test
    public void testInsert() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        queue.insert("Andrew", 69);
        assertEquals(queue.size(), 1);
        assertTrue(queue.isMinHeap(0));

        queue.insert("Ray", 55);
        assertTrue(queue.isMinHeap(0));
    }

    @Test
    public void testSize() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertEquals(queue.size(), 0);

        queue.insert("Jonathan", 69);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testExtractMaxPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.insert("Jonathan", 69);
        queue.insert("Marian", 12);
        queue.insert("Alex", 56);
        queue.insert("Jay", 25);

        assertEquals(queue.extractMaxPriority(), "Jonathan");

        // Double Check the heap property
        assertTrue(queue.isMinHeap(0));
        assertEquals(queue.size(),3);
        assertEquals(queue.toString(), "[Marian, Alex, Jay]");
    }

    @Test
    public void testToString() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertEquals(queue.toString(), "[]");

        queue.insert("Matthew", 40);
        assertEquals(queue.toString(),"[Matthew]");

        queue.insert("Andrew", 12);
        assertEquals(queue.toString(), "[Andrew, Matthew]");

        queue.insert("Jonathan", 5);
        assertEquals(queue.toString(), "[Jonathan, Matthew, Andrew]");

        queue.insert("Marian", 34);
        assertEquals(queue.toString(),"[Jonathan, Marian, Andrew, Matthew]");
    }
}