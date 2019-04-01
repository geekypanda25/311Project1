import java.awt.*;

public class Node {

    public final int RED = 0;
    public final int BLACK = 1;


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

    public boolean isNil() {
        return (this.key == -1);
    }

    public void setColor(int color) {
        if(color == BLACK) {
            this.color = BLACK;
        }
        else {
            this.color = RED;
        }
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }
}
