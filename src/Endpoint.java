public class Endpoint {

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