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

    public int size() { return nodesInserted; }

    public void push(String name, int priority) {
        nodesInserted += 1;
        int lastPosition = nodesInserted - 1;
        queue[lastPosition].setName(name);
        queue[lastPosition].setPriority(priority);
    }

    public boolean isEmpty() { return size() == 0; }

    public void insert(String name, int priority) {
        push(name, priority);
        int lastPosition = size() - 1;
        siftUp(0, lastPosition);
    }

    public String extractMinName() { return queue[0].getName(); }

    public void deleteMin() {
        int lastPosition = size() - 1;
        queue[0] = queue[lastPosition];
        queue[lastPosition] = new Node(); // clear out last position
        nodesInserted -= 1;
    }

    public String remove() {
        String minNodeName = extractMinName();

        deleteMin();

        int lastPosition = size() - 1;
        siftDown(0, lastPosition);
        return minNodeName;
    }

    private void swap(int parentPosition, int childPosition) {
        Node temp = queue[parentPosition];
        queue[parentPosition] = queue[childPosition];
        queue[childPosition] = temp;
    }

    // Restore heap property after insertion, "bottom up"
    private void siftUp(int startPosition, int endPosition) {
        int childPosition = endPosition;
        while(childPosition > startPosition) {
            int parentPosition = (childPosition - 1) / 2;
            if(queue[parentPosition].getPriority() > queue[childPosition].getPriority()) {
                swap(parentPosition, childPosition);
            }
            childPosition = parentPosition;
        }
    }

    // restore heap property after deletion, "top-down"
    private void siftDown(int startPosition, int endPosition) {
        int rootPosition = startPosition;

        while(leftChildPosition(rootPosition) <= endPosition) {
            int child = leftChildPosition(rootPosition);
            int swapPosition = rootPosition;

            // if parentPriority greater than leftChildPriority -> not min heap, swapPosition is now leftChild
            if(queue[swapPosition].getPriority() > queue[child].getPriority()) {
                swapPosition = child;
            }

            // If rightChildPosition is less than or equal to the endPosition -AND- the parentPriority greater than rightChildPriority ->
            // not min heap, swapPosition is now rightChild
            if((rightChildPosition(rootPosition) <= endPosition) && queue[swapPosition].getPriority() > queue[rightChildPosition(rootPosition)].getPriority()) {
                swapPosition = rightChildPosition(rootPosition);
            }

            // if swapPosition is still equal to the rootPosition, -> this is a minHeap, break out of function
            if (swapPosition == rootPosition) {
                break;
            } else {
                // A swap needs to occur
                swap(rootPosition, swapPosition);
                rootPosition = swapPosition; // continue to siftDown and restore the heap property
            }
        }
    }

    private int leftChildPosition(int parentPosition) {
        return ((2 * parentPosition) + 1);
    }

    private int rightChildPosition(int parentPosition) {
        return ((2 * parentPosition) + 2);
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
