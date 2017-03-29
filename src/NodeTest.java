import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by avogel on 2/13/17.
 */
public class NodeTest {

    @Test
    public void testNewNode() throws Exception {
        Node node = new Node("node_name", 10);
        assertNotEquals(node,null);
    }

    @Test
    public void testGetPriority() throws Exception {
        Node node = new Node("node_name", 10);
        assertEquals(node.getPriority(), 10);
    }

    @Test
    public void testGetName() throws Exception {
        Node node = new Node("node_name", 10);
        assertEquals(node.getName(), "node_name");
    }
}