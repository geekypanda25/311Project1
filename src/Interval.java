public class Interval {

    private int a, b, ID;


    /**
     * Constructs Interval object to hold information about an
     *   instance of any Interval.
     * @param a
     * The Interval's left endpoint value
     * @param b
     * The Interval's right endpoint value
     * @param ID
     * The Interval's unique ID
     */
    public Interval(int a, int b, int ID) {
        this.a = a;
        this.b = b;
        this.ID = ID;
    }


    public int getA() {
        return a;
    }


    public int getB() {
        return b;
    }


    public int getID() {
        return ID;
    }
}
