import java.util.Arrays;

/**
 * Priority Queue - Min Heap Backed Implentation
 * Created by avogel on 2/13/17.
 */
public class PriorityQueue {
    // Heap backed implementation
    // Min Heap (see max heap comment)
    private Node[] queue;
    private int nodesInserted; // counts the number of nodes inserted

    public PriorityQueue() {
        queue = new Node[255];
        for(int i = 0; i < queue.length; i++) {
            queue[i] = new Node();
        }
        nodesInserted = 0;
    }

    public void insert(String name, int priority) {
        nodesInserted += 1;
        int lastPosition = nodesInserted - 1;
        queue[lastPosition].setName(name);
        queue[lastPosition].setPriority(priority);
        heapify();
    }

    public boolean isMinHeap(int fromPosition) {
        if(fromPosition <= 0) {
            return true;
        } else {
            Node child = queue[fromPosition];
            int parentPosition = (fromPosition - 1) / 2;
            Node parent = queue[parentPosition];
            return (child.getPriority() > parent.getPriority() && isMinHeap(fromPosition - 1));
        }

    }

    public void heapify() {
        int lastPosition = size() - 1;

        while(!isMinHeap(lastPosition)) {
            // Store the child node in temp
            Node temp = queue[lastPosition];

            // Put the parent node in the child position
            int parentPostion = (lastPosition - 1) / 2;
            queue[lastPosition] = queue[parentPostion];

            // Put the child (temp) in the parent position
            queue[parentPostion] = temp;
            lastPosition = parentPostion;

            lastPosition--;
        }
    }

    // O(log n)
    // aka - remove(), pop()
    public String extractMaxPriority() {

    }

    public int size() {
        return nodesInserted;
    }

    @Override
    public String toString() {
        String[] queuesNames = new String[nodesInserted];
        for(int i = 0; i < nodesInserted; i++) {
            queuesNames[i] = queue[i].getName();
        }
        return Arrays.toString(queuesNames);
    }

}
