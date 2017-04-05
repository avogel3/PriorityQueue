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

    public int size() {
        return nodesInserted;
    }

    public void push(String name, int priority) {
        nodesInserted += 1;
        int lastPosition = nodesInserted - 1;
        queue[lastPosition].setName(name);
        queue[lastPosition].setPriority(priority);
    }

    public boolean isEmpty() { return size() == 0; }

    public boolean isMinHeap(int fromPosition) {
        if(isEmpty()) {
            return false;
        }

        if(fromPosition <= 0) {
            return true;
        }

        Node child = queue[fromPosition];
        int parentPosition = (fromPosition - 1) / 2;
        Node parent = queue[parentPosition];
        return (child.getPriority() > parent.getPriority() && isMinHeap(fromPosition - 1));
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

    public void insert(String name, int priority) {
        push(name, priority);
        heapify();
    }

    public Node extractMin() { return queue[0]; }

    public void deleteMin() {
        int lastPosition = size() - 1;
        queue[0] = queue[lastPosition];
        queue[lastPosition] = new Node(); // clear out last position
        nodesInserted -= 1;
    }

    public String remove() {
        Node min = extractMin();
        deleteMin();

        heapify();
        return min.getName();
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
