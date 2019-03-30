public class RBTree{

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
}
