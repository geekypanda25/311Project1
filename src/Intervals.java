import java.util.ArrayList;
/**
 * @author Benjamin Ferreira, John Schnoebelen, Shlok Singh
 */
public class Intervals {


    public int currID;
    public RBTree rbTree;
    public ArrayList<Node> nodes;
    public ArrayList<Interval> IntervalArray;


    public Intervals(){
        currID = 0;
        rbTree = new RBTree();
        nodes = new ArrayList<>();
        IntervalArray = new ArrayList<>();
    }


    public void intervalInsert(int a, int b) {
        if (b<a) {
            int last = b;
            b = a;
            a = last;
        }

        IntervalArray.add(new Interval(a,b,currID));

        Node n1 = new Node();
        Node n2 = new Node();
        Endpoint e1 = new Endpoint(a, Endpoint.LEFT);
        Endpoint e2 = new Endpoint(b, Endpoint.RIGHT);

        e1.value=a;
        e2.value=b;
        e1.Id = currID;
        e2.Id = currID;
        e1.p = Endpoint.LEFT;
        e2.p = Endpoint.RIGHT;
        n1.key = e1;
        n2.key = e2;

        rbTree.insert(n1);
        rbTree.insert(n2);

        nodes.add(n1);
        nodes.add(n2);

        currID++;
    }

    public boolean intervalDelete(int intervalID){

        return false;
    }

    public int findPOM() {

        if (rbTree.getSize() == 0) {
            return 0;
        }
        return rbTree.getRoot().getMaxVal();
    }


    public RBTree getRBTree() {

        return rbTree;
    }
}
