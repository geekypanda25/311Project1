import java.util.ArrayList;

public class Intervals {


    private int currID;
    private Interval currInterval;
    private ArrayList<Interval> IntervalArray = new ArrayList<>();


    public Intervals() {
        currID = 1;

    }


    public void intervalInsert(int a, int b) {

        // add new Interval object to the IntervalArray
        currInterval = new Interval(a, b, currID);
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
