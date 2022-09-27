import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Customer.generateCustomerFile();
        Transaction.generateTransactionFile();
        System.out.println("files created");
    }
}
