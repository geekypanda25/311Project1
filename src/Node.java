public class Node {

    private final int RED = 0;
    private final int BLACK = 1;

    private Node left = null, right = null, parent = null;
    private int key = -1, p = 0, val = -1, maxVal = -1, color = BLACK;
    private Endpoint endpoint, eMax;


    public Node(int key) {
        this.key = key;
    }

    public Node getParent(){
        return null;
    }

    public Node getLeft(){

        return null;
    }

    public Node getRight(){

        return null;
    }

    public int getKey(){

        return 0;
    }

    public int getP(){

        return 0;
    }

    public int getVal(){

        return 0;
    }

    public int getMaxVal(){

        return 0;
    }

    public Endpoint getEndpoint(){

        return null;
    }

    public Endpoint getEmax(){

        return null;
    }

    public int getColor(){

        return color;
    }
}
