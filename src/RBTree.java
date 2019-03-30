public class RBTree{

    private final int RED = 0;
    private final int BLACK = 1;

    private Node root = null;
    private Node NILNode = null;
    private int size = -1;
    private int height = -1;

    public RBTree(){
        size = 0;
        height = 0;
        NILNode = new Node(-1);
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

    private void insert(Node node) {
        Node temp = root;
        if (root == NILNode) {
            root = node;
            node.getColor() = BLACK;
            node.getParent() = NILNode;
        } else {
            node.getColor() = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == NILNode) {
                        temp.left = node;
                        node.getParent() = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key >= temp.key) {
                    if (temp.right == NILNode) {
                        temp.right = node;
                        node.getParent() = temp;
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
    private void fixTree(Node node) {
        while (node.getParent().getColor() == RED) {
            Node uncle = NILNode;
            if (node.getParent() == node.getParent().getParent().left) {
                uncle = node.getParent().getParent().right;

                if (uncle != NILNode && uncle.getColor() == RED) {
                    node.getParent().getColor() = BLACK;
                    uncle.getColor() = BLACK;
                    node.getParent().getParent().getColor() = RED;
                    node = node.getParent().getParent();
                    continue;
                }
                if (node == node.getParent().right) {
                    //Double rotation needed
                    node = node.getParent();
                    rotateLeft(node);
                }
                node.getParent().getColor() = BLACK;
                node.getParent().getParent().getColor() = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateRight(node.getParent().getParent());
            } else {
                uncle = node.getParent().getParent().left;
                if (uncle != NILNode && uncle.getColor() == RED) {
                    node.getParent().getColor() = BLACK;
                    uncle.getColor() = BLACK;
                    node.getParent().getParent().getColor() = RED;
                    node = node.getParent().getParent();
                    continue;
                }
                if (node == node.getParent().left) {
                    //Double rotation needed
                    node = node.getParent();
                    rotateRight(node);
                }
                node.getParent().getColor() = BLACK;
                node.getParent().getParent().getColor() = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.getParent().getParent());
            }
        }
        root.getColor() = BLACK;
    }

    void rotateLeft(Node node) {
        if (node.getParent() != NILNode) {
            if (node == node.getParent().left) {
                node.getParent().left = node.right;
            } else {
                node.getParent().right = node.right;
            }
            node.right.getParent() = node.getParent();
            node.getParent() = node.right;
            if (node.right.left != NILNode) {
                node.right.left.getParent() = node;
            }
            node.right = node.right.left;
            node.getParent().left = node;
        } else {//Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.getParent() = root;
            root.getParent() = right;
            right.left = root;
            right.getParent() = NILNode;
            root = right;
        }
    }

    void rotateRight(Node node) {
        if (node.getParent() != NILNode) {
            if (node == node.getParent().left) {
                node.getParent().left = node.left;
            } else {
                node.getParent().right = node.left;
            }

            node.left.getParent() = node.getParent();
            node.getParent() = node.left;
            if (node.left.right != NILNode) {
                node.left.right.getParent() = node;
            }
            node.left = node.left.right;
            node.getParent().right = node;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.getParent() = root;
            root.getParent() = left;
            left.right = root;
            left.getParent() = NILNode;
            root = left;
        }
    }
}
