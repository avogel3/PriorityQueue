import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by avogel on 3/29/17.
 */
public class PriorityQueueTest {
    @Test
    public void testSize() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertEquals(queue.size(), 0);

        queue.insert("Jonathan", 69);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testPush() {
        PriorityQueue queue = new PriorityQueue();
        queue.push("Walter", 21);
        queue.push("Matthew", 13);
        queue.push("Hermine", 8);

        assertFalse(queue.isMinHeap(queue.size() - 1));
        assertEquals("[Walter, Matthew, Hermine]", queue.toString());
    }

    @Test
    public void isEmpty() {
        PriorityQueue queue = new PriorityQueue();
        assertTrue(queue.isEmpty());

        queue.insert("Walter", 21);
        assertFalse(queue.isEmpty());
    }


    @Test
    public void testIsMinHeap() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertFalse(queue.isMinHeap(queue.size() - 1));

        queue.push("Hermine", 8);
        queue.push("Matthew", 13);
        queue.push("Lisa", 12);

        assertTrue(queue.isMinHeap(queue.size() - 1));
        assertEquals("[Hermine, Matthew, Lisa]", queue.toString());

        queue.push("Julia", 10);
        assertFalse(queue.isMinHeap(queue.size() - 1));
    }


    @Test
    public void testInsert() throws Exception {
        PriorityQueue queue = new PriorityQueue();

        queue.insert("Matthew", 13);
        assertEquals(1, queue.size());
        assertEquals("[Matthew]", queue.toString());
        assertTrue(queue.isMinHeap(queue.size() - 1));

        queue.insert("Hermine", 8);
        assertEquals(2, queue.size());
        assertEquals("[Hermine, Matthew]", queue.toString());
        assertTrue(queue.isMinHeap(queue.size() - 1));

        queue.insert("Lisa", 12);
        assertEquals(3, queue.size());
        assertEquals("[Hermine, Matthew, Lisa]", queue.toString());
        assertTrue(queue.isMinHeap(queue.size() - 1));

        queue.insert("Julia", 10);
        assertEquals(4, queue.size());
        assertEquals("[Hermine, Julia, Lisa, Matthew]", queue.toString());
        assertTrue(queue.isMinHeap(queue.size() - 1));
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