public class Endpoint {

    public int value = -1, p = 0;

    public final static int LEFT = 1;
    public final static int RIGHT = -1;
    public int Id;

    /**
     * Constructs a new Endpoint using the inputted value
     * @param value
     * The value of the Endpoint given by intervalInsert()
     */
    public Endpoint(int value, int p) {
        this.value = value;
        this.p = p;
    }


    /**
     * Returns the endpoint value of the Endpoint object
     * @return
     * The endpoint value
     */
    public int getValue() {
        return value;
    }


    public int getP() {
        return p;
    }
}