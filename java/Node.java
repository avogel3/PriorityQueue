/**
 * Created by avogel on 1/2/17.
 */
public class Node {
    private int priority;
    private String name;

    public Node() {
        this.name = "__empty__";
        this.priority = -1;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setPriority(int newPriority) {
        priority = newPriority;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }
}
