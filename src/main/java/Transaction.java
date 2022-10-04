
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Transaction {

    static final int transactions = 5000000;
    static final int customers = 50000;
    /**
     * unique sequential number (integer) from 1 to 5,000,000 (the file has 5M transactions)
     */
    int transID;

    /**
     * from 1 to 50,000 (on Avg. a customer has 100 trans.)
     */
    int custID;

    /**
     * random number (float) between 10 and 1000
     */
    float transTotal;

    /**
     * random number (integer) between 1 and 10
     */
    int transNumItems;

    /**
     * random text of characters of length between 20 and 50 (do not include commas)
     */
    String transDesc;


    public Transaction(int transID, int custID, float transTotal, int transNumItems, String transDesc) {
        this.transID = transID;
        this.custID = custID;
        this.transTotal = transTotal;
        this.transNumItems = transNumItems;
        this.transDesc = transDesc;
    }

    public static void generateTransactionFile() throws IOException {


        //transaction IDs
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= transactions; i++) {
            ids.add(i);
        }
        Collections.shuffle(ids);

        //customer ids
        ArrayList<Integer> custIDs = new ArrayList<>();
        int random;
        for (int i = 1; i <= transactions; i++) {
            //varying the number of transactions per customer,
            // while keeping the avg of 100 transactions/customer
            int randNumChange = Util.generateRandomNumber(1, 10);
            if (randNumChange <= 8) {               //80% possibility
                if (randNumChange <= 4) {           //50% possibility add random num in range
                    random = Util.generateRandomNumber(0, calcMaxValueForAdding(i));
                    custIDs.add((i % customers) + 1 + random);
                } else {                            //subtract random num in range
                    random = Util.generateRandomNumber(0, calcMaxValueForSubtracting(i));
                    custIDs.add((i % customers) + 1 - random);
                }
            } else {
                custIDs.add((i % customers) + 1);
            }
        }
        Collections.shuffle(ids);


        // transaction total value
        ArrayList<Integer> transTotal = new ArrayList<>();
        for (int i = 0; i < transactions; i++) {
            transTotal.add(Util.generateRandomNumber(10, 1000));
        }


        // number of items
        ArrayList<Integer> transNumItems = new ArrayList<>();
        for (int i = 0; i < transactions; i++) {
            transNumItems.add(Util.generateRandomNumber(1, 10));
        }


        //transaction description
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz" + " §$%&/()=?ß";
        ArrayList<String> transDesc = new ArrayList<>();

        for (int i = 0; i < transactions; i++) {
            int n = Util.generateRandomNumber(20, 50);
            StringBuilder sb = new StringBuilder(n);

            for (int j = 0; j < n; j++) {
                int index = (int) (chars.length() * Math.random());
                sb.append(chars.charAt(index));
            }
            transDesc.add(sb.toString());
        }


        // Open/Create the file.
        File file = new File("transactions.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < transactions; i++) {
            bw.write((ids.get(i)) + "," + (custIDs.get(i)) + "," + (transTotal.get(i)) + "," + (transNumItems.get(i)) + "," + transDesc.get(i));
            bw.newLine();
        }

        bw.close();
        fw.close();


    }

    private static int calcMaxValueForAdding(int index) {
        //(index%customers)+1 = numbers from 1 - 50.000
        //(index%customers)+1 + maxValue <= customers
        //maxValue <= customers - ((index%customers)+1)
        return (customers - (index % customers) - 1);
    }

    private static int calcMaxValueForSubtracting(int index) {
        //(index%customers)+1 = numbers from 1 - 50.000
        //(index%customers)+1 - maxValue >= 1
        //(index%customers) >= maxValue
        return (index % customers);
    }
}
