/**
 * Created by avogel on 2/13/17.
 */
public class PriorityQueue {
    // Heap backed implementation
    private Node[] queue;

    public PriorityQueue() {
        queue = new Node[255];
    }

    public void insert(Node node) {
        int lastPosition = queue.length - 1;
        queue[lastPosition] = node;
        while(!isMaxHeap()) {

        }
    }

    public boolean isMaxHeap() {
        return false;
    }

}
