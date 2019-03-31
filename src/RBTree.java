public class RBTree{

    private final int RED = 0;
    private final int BLACK = 1;

    private Node root = null;
    private Node NILNode = null;
    private int size = -1;
    private int height = -1;
    int sleft, sright, sparent;

    public RBTree(){
        size = 0;
        height = 0;
        NILNode = new Node(new Endpoint(-1, 0));
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
            node.setColor(BLACK);
            node.setParent(NILNode);
        } else {
            node.setColor(RED);
            while (true) {
                if (node.getKey() < temp.getKey()) {
                    if (temp.getLeft() == NILNode) {
                        temp.setLeft(node); sleft=1;
                        node.setParent(temp); sparent=1;
                        break;
                    } else {
                        temp = temp.getLeft();
                    }
                } else if (node.getKey() >= temp.getKey()) {
                    if (temp.getRight() == NILNode) {
                        temp.setRight(node); sright=1;
                        node.setParent(temp); sparent=1;
                        break;
                    } else {
                        temp = temp.getRight();
                    }
                }
            }
            fixTree(node);
        }
    }

    //Takes as argument the newly inserted node
    public void fixTree(Node node) {
        while (node.getParent().getColor() == RED) {
            Node uncle = NILNode;
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();

                if (uncle != NILNode && uncle.getColor() == RED) {
                    node.getParent().setColor(BLACK);
                    uncle.setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    node = node.getParent().getParent();
                    continue;
                }
                if (node == node.getParent().getRight()) {
                    //Double rotation needed
                    node = node.getParent();
                    rotateLeft(node);
                }
                node.getParent().setColor(BLACK);
                node.getParent().getParent().setColor(RED);
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateRight(node.getParent().getParent());
            } else {
                uncle = node.getParent().getParent().getLeft();
                if (uncle != NILNode && uncle.getColor() == RED) {
                    node.getParent().setColor(BLACK);
                    uncle.setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    node = node.getParent().getParent();
                    continue;
                }
                if (node == node.getParent().getLeft()) {
                    //Double rotation needed
                    node = node.getParent();
                    rotateRight(node);
                }
                node.getParent().setColor(BLACK);
                node.getParent().getParent().setColor(RED);
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.getParent().getParent());
            }
        }
        root.setColor(BLACK);
    }

    public void rotateLeft(Node node) {
        if (node.getParent() != NILNode) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getRight());
            } else {
                node.getParent().setRight(node.getRight());
            }
            node.getRight().setParent(node.getParent());
            node.setParent(node.getRight());
            if (node.getRight().getLeft() != NILNode) {
                node.getRight().getLeft().setParent(node);
            }
            node.setRight(node.getRight().getLeft());
            node.getParent().setLeft(node);
        } else {//Need to rotate root
            Node right = root.getRight();
            root.setRight(right.getLeft());
            right.getLeft().setParent(root);
            root.setParent(right);
            right.setLeft(root);
            right.setParent(NILNode);
            root = right;
        }
    }

    public void rotateRight(Node node) {
        if (node.getParent() != NILNode) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getLeft());
            } else {
                node.getParent().setRight(node.getLeft());
            }

            node.getLeft().setParent(node.getParent());
            node.setParent(node.getLeft());
            if (node.getLeft().getRight() != NILNode) {
                node.getLeft().getRight().setParent(node);
            }
            node.setLeft(node.getLeft().getRight());
            node.getParent().setRight(node);
        } else {//Need to rotate root
            Node left = root.getLeft();
            root.setLeft(root.getLeft().getRight());
            left.getRight().setParent(root);
            root.setParent(left);
            left.setRight(root);
            left.setParent(NILNode);
            root = left;
        }
    }
}
