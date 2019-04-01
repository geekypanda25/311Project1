import java.awt.*;
/**
 * @author Benjamin Ferreira, John Schnoebelen, Shlok Singh
 */
public class Node {

    public final int RED = 0;
    public final int BLACK = 1;


    Endpoint key = null;

    public Node left = null, right = null, parent = null;
    public int color = BLACK;
    int val, maxval;
    Endpoint exmax;


//    private int key = -1, p = 0, val = -1, maxVal = -1, color = BLACK;
//    private Endpoint endpoint, eMax;


//    public Node(Endpoint endpoint) {
//        this.endpoint = endpoint;
//        key = endpoint.getValue();
//        p = endpoint.getP();
//    }

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
        return key.getValue();
    }

    public int getP(){
        return key.p;
    }

    public int getVal(){
        return val;
    }

    public int setVal(){
        if (key == null) {
            val = 0;
        }
        else {
            val = left.setVal() + key.p + right.setVal();
        }
        return val;
    }

    public int setMaxVal(){

        if(key.equals(null)){
            return 0;
        }
        maxval = Math.max(Math.max(this.getLeft().getMaxVal(), this.getLeft().getVal() + this.getP()), this.getLeft().getVal()+this.getP() + this.getRight().getMaxVal());
        return maxval;
    }

    public int getMaxVal() {
        this.setMaxVal();
        return maxval;
    }


    public Endpoint getEndpoint(){
        return key;
    }

    public Endpoint getEmax(){
        return exmax;
    }

    public void setEmax(){ //occurs at the endpoint where maxVal would occur, according to post on Piazza
        int max =this.getMaxVal();/* Math.max(Math.max(this.getLeft().maxval, this.getLeft().getVal() + this.getP()),
    			this.getLeft().getVal()+this.getP() + this.getRight().maxval);*/

        if(max == this.getLeft().maxval /*&& this.getLeft().getEndpoint() != null*/ ){
            exmax = this.getLeft().getEndpoint();
        }
        else if((max ==  this.getLeft().getVal() + this.getP()) /*&&  this.getEndpoint() != null*/){
            exmax = this.getEndpoint();
        }

        else if((max == this.getLeft().getVal()+this.getP() + this.getRight().maxval )/*&& this.getRight().getEndpoint() != null*/){
            exmax = this.getRight().getEndpoint();
        }
        else {
            System.out.println("error setting the Emax");
        }
    }

    public int getColor(){
        return color;
    }

    public void setKey(Endpoint key){
        this.key = key;
    }
}

//    public boolean isNil() {
//        return (this.key == -1);
//    }

//    public void setColor(int color) {
//        if(color == BLACK) {
//            this.color = BLACK;
//        }
//        else {
//            this.color = RED;
//        }
//    }
//
//    public void setParent(Node node) {
//        this.parent = node;
//    }
//
//    public void setLeft(Node node) {
//        this.left = node;
//    }
//
//    public void setRight(Node node) {
//        this.right = node;
//    }
//}
