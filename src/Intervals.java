import java.util.ArrayList;

public class Intervals {


    private int currID;
    private Interval currInterval = null;
    private ArrayList<Interval> IntervalArray = new ArrayList<>();


    public Intervals() {
        currID = 1;

    }


    public void intervalInsert(int a, int b) {

        // creates two new Endpoint objects based on the endpoint values
        Endpoint leftE = new Endpoint(a);
        Endpoint rightE = new Endpoint(b);

        // add new Interval object to the IntervalArray
        currInterval = new Interval(leftE, rightE, currID);
        IntervalArray.add(currInterval);
        currID++;
    }


    public int findPOM() {

        return 0; // temp
    }


    public RBTree getRBTree() {

        return null; // temp
    }

}
