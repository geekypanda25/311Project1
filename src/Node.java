import java.awt.*;
/**
 * @author Benjamin Ferreira, John Schnoebelen, Shlok Singh
 */
public class Node {

    public final int RED = 0;
    public final int BLACK = 1;

    public Node left = null, right = null, parent = null;
    public int color = BLACK;
    int val, maxval;
    Endpoint exmax;
    Endpoint key = null;

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

    public void setEmax(){
        int maxValue = this.getMaxVal();

        if(maxValue == this.getLeft().maxval){
            exmax = this.getLeft().getEndpoint();
        }
        else if((maxValue ==  this.getLeft().getVal() + this.getP())){
            exmax = this.getEndpoint();
        }

        else if((maxValue == this.getLeft().getVal()+this.getP() + this.getRight().maxval)){
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

