import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeTest {

    // Instance variables
    RBTree tree;
    Node node1;
    Node node2;
    Node node3;
    Node node4;
    Node node5;
    Node node6;

    @Before
    public void initialize() {
        tree = new RBTree();
        node1 = new Node();
        node2 = new Node();
        node3 = new Node();
        node4 = new Node();
        node5 = new Node();
        node6 = new Node();
    }

    @Test
    public void testGetRoot() {

        // Root should initially be NIL
        //assertTrue(tree.getRoot().isNil());

        // Insert node, which is new root
        tree.insert(node1);
        //assertFalse(tree.getRoot().isNil());
        assertEquals(tree.root.key, 1);

        // New insert keeps the same root as before
        tree.insert(node2);
        assertEquals(tree.root.key, 1);

        // Rotation results in new root
        tree.insert(node3);
        assertEquals(tree.root.key, 2);
    }

    @Test
    public void testGetNILNode() {
        Node nilNode = tree.NILNode;
        //assertTrue(nilNode.isNil());
        assertEquals(nilNode.color, 1);
        tree.insert(node1);
        assertEquals(tree.NILNode, nilNode);   // NIL node shouldn't change after insert
    }

    @Test
    public void testGetSize() {
        assertEquals(tree.getSize(), 0);
        tree.insert(node1);
        assertEquals(tree.getSize(), 1);
        tree.insert(node2);
        assertEquals(tree.getSize(), 2);
        tree.insert(node3);
        assertEquals(tree.getSize(), 3);
    }

    @Test
    public void testGetHeight() {
        assertEquals(tree.getHeight(), 0);
        tree.insert(node3);
        assertEquals(tree.getHeight(), 1);
        tree.insert(node2);
        assertEquals(tree.getHeight(), 2);
        tree.insert(node4);
        assertEquals(tree.getHeight(), 2);
        tree.insert(node5);
        assertEquals(tree.getHeight(), 3);
        tree.insert(node6);
        assertEquals(tree.getHeight(), 3);  // Rotation keeps height at 3
    }
}
