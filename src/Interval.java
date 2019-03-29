public class Interval {

    private int ID;
    private Endpoint left, right;


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
    public Interval(Endpoint left, Endpoint right, int ID) {
        this.left = left;
        this.right = right;
        this.ID = ID;
    }


    public Endpoint getLeft() {
        return left;
    }


    public Endpoint getRight() {
        return right;
    }


    public int getID() {
        return ID;
    }
}
