import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer.generateCustomerFile();
        Transaction.generateTransactionFile();
        System.out.println("files created");
    }
}
