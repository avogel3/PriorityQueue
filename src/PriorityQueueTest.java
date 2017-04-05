import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by avogel on 3/29/17.
 */
public class PriorityQueueTest {
    @Test public void testSize() throws Exception {
        PriorityQueue queue = new PriorityQueue();
        assertEquals(queue.size(), 0);

        queue.insert("Jonathan", 69);
        assertEquals(queue.size(), 1);
    }

    @Test public void testPush() {
        PriorityQueue queue = new PriorityQueue();
        queue.push("Walter", 21);
        queue.push("Matthew", 13);
        queue.push("Hermine", 8);

        assertEquals("[Walter, Matthew, Hermine]", queue.toString());
    }

    @Test public void isEmpty() {
        PriorityQueue queue = new PriorityQueue();
        assertTrue(queue.isEmpty());

        queue.insert("Walter", 21);
        assertFalse(queue.isEmpty());
    }

    @Test public void testInsert() throws Exception {
        PriorityQueue queue = new PriorityQueue();

        queue.insert("Matthew", 13);
        assertEquals(1, queue.size());
        assertEquals("[Matthew]", queue.toString());

        queue.insert("Hermine", 8);
        assertEquals(2, queue.size());
        assertEquals("[Hermine, Matthew]", queue.toString());

        queue.insert("Lisa", 12);
        assertEquals(3, queue.size());
        assertEquals("[Hermine, Matthew, Lisa]", queue.toString());

        queue.insert("Julia", 10);
        assertEquals(4, queue.size());
        assertEquals("[Hermine, Julia, Lisa, Matthew]", queue.toString());
    }

    @Test public void testExtractMinName() {
        PriorityQueue queue = new PriorityQueue();
        queue.insert("Matthew", 13);
        queue.insert("Hermine", 8);
        assertEquals("Hermine", queue.extractMinName());
    }

    @Test public void testDeleteMin() {
        PriorityQueue queue = new PriorityQueue();
        queue.insert("Matthew", 13);
        queue.insert("Hermine", 8);
        queue.deleteMin();
        assertEquals(1, queue.size());
        assertEquals("[Matthew]", queue.toString());
    }

    @Test public void testRemove() {
        PriorityQueue queue = new PriorityQueue();

        queue.insert("Michael", 18);
        queue.insert("Hermine", 8);
        queue.insert("Lisa", 12);
        queue.insert("Julia", 10);

        assertEquals("Hermine", queue.remove());
        assertEquals("[Julia, Michael, Lisa]", queue.toString());
    }

    @Test public void testToString() throws Exception {
        PriorityQueue queue = new PriorityQueue();

        assertEquals(queue.toString(), "[]");

        queue.insert("Matthew", 13);
        assertEquals(queue.toString(),"[Matthew]");

        queue.insert("Hermine", 8);
        assertEquals(queue.toString(), "[Hermine, Matthew]");

        queue.insert("Lisa", 12);
        assertEquals(queue.toString(), "[Hermine, Matthew, Lisa]");

        queue.insert("Julia", 10);
        assertEquals(queue.toString(),"[Hermine, Julia, Lisa, Matthew]");
    }


}