import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RBOperationsTest {

    // Instance variables
    RBTree tree;
    Node node1;
    Node node2;
    Node node3;
    Node node4;

    @Before
    public void initialize() {
        tree = new RBTree();
        node1 = new Node(new Endpoint(1, 1));
        node2 = new Node(new Endpoint(2, 1));
        node3 = new Node(new Endpoint(3, 1));
        node4 = new Node(new Endpoint(4, 1));
    }

    @Test
    public void firstInsert() {
        tree.insert(node1);
        assertEquals(tree.getRoot().getKey(), 1);
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);
    }

    @Test
    public void leftInsert() {
        tree.insert(node2);
        tree.insert(node1);
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);
        assertEquals(tree.getRoot().getLeft().getKey(), 1);
        assertEquals(tree.getRoot().getLeft().getColorInEnum(), Color.RED);
        assertTrue(tree.getRoot().getRight().isNil());
    }

    @Test
    public void rightInsert() {
        tree.insert(node2);
        tree.insert(node3);
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);
        assertEquals(tree.getRoot().getRight().getKey(), 3);
        assertEquals(tree.getRoot().getRight().getColorInEnum(), Color.RED);
        assertTrue(tree.getRoot().getLeft().isNil());
    }

    @Test
    public void leftRightInsert() {

        // Build tree
        tree.insert(node2);
        tree.insert(node1);
        tree.insert(node3);

        // Test initial insertion
        assertEquals(tree.getRoot().getKey(), node2.getKey());
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);

        // Test root's children
        Node left = tree.getRoot().getLeft();
        Node right = tree.getRoot().getRight();
        assertEquals(left.getKey(), node1.getKey());
        assertEquals(right.getKey(), node3.getKey());
        assertEquals(left.getParent().getKey(), node2.getKey());
        assertEquals(right.getParent().getKey(), node2.getKey());
        assertEquals(left.getColorInEnum(), Color.RED);
        assertEquals(right.getColorInEnum(), Color.RED);

        // Test children's children are nil
        assertTrue(left.getLeft().isNil());
        assertTrue(left.getRight().isNil());
        assertTrue(right.getLeft().isNil());
        assertTrue(right.getRight().isNil());

    }

    @Test
    public void insertWithLeftRotation() {

        // Build tree
        tree.insert(node1);
        tree.insert(node2);
        tree.insert(node3);

        // Test root after rotation
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);

        // Test children
        Node left = tree.getRoot().getLeft();
        Node right = tree.getRoot().getRight();
        assertEquals(left.getKey(), 1);
        assertEquals(right.getKey(), 3);
        assertEquals(left.getParent(), tree.getRoot());
        assertEquals(right.getParent(), tree.getRoot());
        assertEquals(left.getColorInEnum(), Color.RED);
        assertEquals(right.getColorInEnum(), Color.RED);

        // Test grandchildren are nil
        assertTrue(left.getLeft().isNil());
        assertTrue(left.getRight().isNil());
        assertTrue(right.getLeft().isNil());
        assertTrue(right.getRight().isNil());
    }

    @Test
    public void insertWithRightRotation() {

        // Build tree
        tree.insert(node3);
        tree.insert(node2);
        tree.insert(node1);

        // Test root after rotation
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);

        // Test children
        Node left = tree.getRoot().getLeft();
        Node right = tree.getRoot().getRight();
        assertEquals(left.getKey(), 1);
        assertEquals(right.getKey(), 3);
        assertEquals(left.getParent(), tree.getRoot());
        assertEquals(right.getParent(), tree.getRoot());
        assertEquals(left.getColorInEnum(), Color.RED);
        assertEquals(right.getColorInEnum(), Color.RED);

        // Test grandchildren are nil
        assertTrue(left.getLeft().isNil());
        assertTrue(left.getRight().isNil());
        assertTrue(right.getLeft().isNil());
        assertTrue(right.getRight().isNil());
    }

    @Test
    public void insertCase3() {

        // Build tree to create case 3 scenario (from Wikipedia)
        tree.insert(node3);
        tree.insert(node2);
        tree.insert(node4);
        tree.insert(node1);

        // Test if colors were repainted correctly
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);
        assertEquals(tree.getRoot().getLeft().getColorInEnum(), Color.BLACK);
        assertEquals(tree.getRoot().getRight().getColorInEnum(), Color.BLACK);
        assertEquals(tree.getRoot().getLeft().getLeft().getColorInEnum(), Color.RED);
    }

    @Test
    public void insertCase4() {

        // Build tree to create case 4 scenario (from Wikipedia)
        tree.insert(node3);
        tree.insert(node1);
        tree.insert(node4);
        tree.getRoot().getRight().setColor(Color.BLACK);    // Set color of uncle to black
        tree.insert(node2);

        // Test rotations
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getLeft().getKey(), 1);
        assertEquals(tree.getRoot().getRight().getKey(), 3);
        assertEquals(tree.getRoot().getRight().getRight().getKey(), 4);
        assertTrue(tree.getRoot().getLeft().getLeft().isNil());
        assertTrue(tree.getRoot().getLeft().getRight().isNil());
        assertTrue(tree.getRoot().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().getLeft().isNil());
        assertTrue(tree.getRoot().getRight().getRight().getRight().isNil());

        // Test colors
        assertEquals(tree.getRoot().getColorInEnum(), Color.BLACK);
        assertEquals(tree.getRoot().getLeft().getColorInEnum(), Color.RED);
        assertEquals(tree.getRoot().getRight().getColorInEnum(), Color.RED);
        assertEquals(tree.getRoot().getRight().getRight().getColorInEnum(), Color.BLACK);
    }
}
