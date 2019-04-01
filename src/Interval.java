public class Interval {

    private int ID;
    //private Endpoint left, right;
    private int x, y, id;


    /**
     * Constructs Interval object to hold information about an
     *   instance of any Interval.
     * @param left
     * The Interval's left endpoint
     * @param right
     * The Interval's right endpoint
     * @param ID
     * The Interval's unique ID
     */
    public Interval(int left, int right, int ID) {
        this.x = left;
        this.y = right;
        this.id = ID;
    }


    public int getLeft() {
        return x;
    }


    public int getRight() {
        return y;
    }


    public int getID() {
        return ID;
    }
}
