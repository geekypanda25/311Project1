/**
 * @author Benjamin Ferreira, John Schnoebelen, Shlok Singh
 */
public class RBTree{

    private final int RED = 0;
    private final int BLACK = 1;

    public Node root = null;
    public Node NILNode = null;
    public int size = -1;
    public int height = -1;


    public RBTree(){
        size = 0;
        height = 0;
        NILNode = new Node();
        root = NILNode;

    }
    public Node getRoot(){
        return root;
    }

    public Node getNILNode(){
        return NILNode;
    }

    public int getSize(){
        return size;
    }

    public int getHeight(){
        return height;
    }

    public void insert(Node node) {
        Node temp = root;
        if (root == NILNode) {
            root = node;
            node.color = BLACK;
            node.parent = NILNode;
        } else {
            node.color = RED;
            while (true) {
                if (node.key.value < temp.key.value) {
                    if (temp.left == NILNode) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key.value >= temp.key.value) {
                    if (temp.right == NILNode) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node);
        }
    }

    //Takes as argument the newly inserted node
    public void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle = NILNode;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != NILNode && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                if (uncle != NILNode && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    public void rotateLeft(Node node) {
        if (node.parent != NILNode) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != NILNode) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = NILNode;
            root = right;
        }
    }

    public void rotateRight(Node node) {
        if (node.parent != NILNode) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != NILNode) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = NILNode;
            root = left;
        }
    }
}
