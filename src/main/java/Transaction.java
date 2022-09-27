public class Transaction {

    /**  unique sequential number (integer) from 1 to 5,000,000 (the file has 5M transactions) */
    int transID;

    /** from 1 to 50,000 (on Avg. a customer has 100 trans.) */
    int custID;

    /** random number (float) between 10 and 1000 */
    float transTotal;

    /** random number (integer) between 1 and 10 */
    int transNumItems;

    /** random text of characters of length between 20 and 50 (do not include commas) */
    String transDesc;


    public Transaction(int transID, int custID, float transTotal, int transNumItems, String transDesc) {
        this.transID = transID;
        this.custID = custID;
        this.transTotal = transTotal;
        this.transNumItems = transNumItems;
        this.transDesc = transDesc;
    }
}
