/**
 * Created by avogel on 1/2/17.
 */
public class Node {
    private int priority;
    private String name;

    public Node(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() { return priority + " " + name; }
}
