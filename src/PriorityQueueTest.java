import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by avogel on 3/29/17.
 */
public class PriorityQueueTest {
    @Test
    public void testInsert() {
        PriorityQueue queue = new PriorityQueue();
    }

    @Test
    public void testIsMaxHeap() {
        PriorityQueue queue = new PriorityQueue();
        assertFalse(queue.isMaxHeap());
    }
}