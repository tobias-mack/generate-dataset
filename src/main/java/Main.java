import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer.generateCustomerFile();
        System.out.println("files created");
    }
}
