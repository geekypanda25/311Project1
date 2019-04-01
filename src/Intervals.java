import java.util.ArrayList;

public class Intervals {


    private int currID;
    private Interval currInterval = null;
    private ArrayList<Interval> IntervalArray = new ArrayList<>();


    public Intervals(){
        nId = 0;
        rbTree = new RBTree();
        nodes = new ArrayList<>();
        intervals = new ArrayList<>();

    }


    public void intervalInsert(int first, int mid) {

        if (mid<first) {
            int last = mid;
            mid = first;
            first = last;
        }

        intervals.add(new Interval(first,mid,nId));

        Node n1 = new Node();
        Node n2 = new Node();
        Endpoint e1 = new Endpoint();
        Endpoint e2 = new Endpoint();

        e1.value=first;
        e2.value=mid;
        e1.Id = nId;
        e2.Id = nId;
        e1.p = Endpoint.LEFT;
        e2.p = Endpoint.RIGHT;
        n1.key = e1;
        n2.key = e2;

        rbTree.RBInsert(n1);
        rbTree.RBInsert(n2);

        nodes.add(n1);
        nodes.add(n2);

        nId++;
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
