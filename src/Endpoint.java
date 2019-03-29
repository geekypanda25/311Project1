public class Endpoint {
//    The Endpoint class represents an endpoint and its value.

    //    int getValue(): Returns the endpoint value. For example if the Endpoint object
//    represents the left endpoint of the interval [1, 3], this would return 1.
    private int value;


    /**
     * Constructs a new Endpoint using the inputted value
     * @param value
     * The value of the Endpoint given by intervalInsert()
     */
    public Endpoint(int value) {
        this.value = value;
    }


    /**
     * Returns the endpoint value of the Endpoint object
     * @return
     * The endpoint value
     */
    public int getValue() {
        return value;
    }
}