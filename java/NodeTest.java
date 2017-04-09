import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by avogel on 2/13/17.
 */
public class NodeTest {

    @Test
    public void testNewNode() throws Exception {
        Node emptyNode = new Node();
        assertEquals(emptyNode.getName(), "__empty__");
        assertEquals(emptyNode.getPriority(), -1);
    }

    @Test
    public void testGetPriority() throws Exception {
        Node node = new Node();
        assertEquals(node.getPriority(), -1);
    }

    @Test
    public void testGetName() throws Exception {
        Node node = new Node();
        assertEquals(node.getName(), "__empty__");
    }

    @Test
    public void testSetName() throws Exception {
        Node node = new Node();
        node.setName("Andrew");
        assertEquals(node.getName(), "Andrew");
    }

    @Test
    public void testSetPriority() throws Exception {
        Node node = new Node();
        node.setPriority(69);
        assertEquals(node.getPriority(), 69);
    }

}