public class Node {

    private final int RED = 0;
    private final int BLACK = 1;

    private Node left = null, right = null, parent = null;
    private int key = -1, p = 0, val = -1, maxVal = -1, color = BLACK;
    private Endpoint endpoint, eMax;


    public Node(Endpoint endpoint) {
        this.endpoint = endpoint;
        key = endpoint.getValue();
        p = endpoint.getP();
    }

    public Node getParent(){
        return parent;
    }

    public Node getLeft(){

        return left;
    }

    public Node getRight(){

        return right;
    }

    public int getKey(){

        return key;
    }

    public int getP(){

        return p;
    }

    public int getVal(){

        return val;
    }

    public int getMaxVal(){

        return maxVal;
    }

    public Endpoint getEndpoint(){

        return endpoint;
    }

    public Endpoint getEmax(){

        return eMax;
    }

    public int getColor(){

        return color;
    }
}
