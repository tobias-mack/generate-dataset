import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Customer {

    /** unique sequential number (integer) from 1 to 50,000 (that is the file will have 50,000 line)*/
    int id;

    /** random sequence of characters of length between 10 and 20 (do not include commas)*/
    String name;

    /** random number (integer) between 10 to 70 */
    int age;

    /** string that is either “male” or “female” */
    String gender;

    /** random number (integer) between 1 and 10 */
    int countryCode;

    /** random number (float) between 100 and 10000 */
    float salary;


    public Customer(int id, String name, int age, String gender, int countryCode, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryCode = countryCode;
        this.salary = salary;
    }

    public static void generateCustomerFile() throws FileNotFoundException {
        // Open/Create the file.
        PrintWriter out = new PrintWriter("customers.txt");

        // generate data and write to file
        out.println("...");

        // Close the file.
        out.close();
    }
}
