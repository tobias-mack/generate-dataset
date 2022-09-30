import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Customer {

    /**
     * unique sequential number (integer) from 1 to 50,000 (that is the file will have 50,000 line)
     */
    int id;

    /**
     * random sequence of characters of length between 10 and 20 (do not include commas)
     */
    String name;

    /**
     * random number (integer) between 10 to 70
     */
    int age;

    /**
     * string that is either “male” or “female”
     */
    String gender;

    /**
     * random number (integer) between 1 and 10
     */
    int countryCode;

    /**
     * random number (float) between 100 and 10000
     */
    float salary;


    public Customer(int id, String name, int age, String gender, int countryCode, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryCode = countryCode;
        this.salary = salary;
    }

    public static void generateCustomerFile() throws IOException {

        //IDs
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (int i = 1; i <= 50000; i++) {
            ids.add(new Integer(i));
        }
        Collections.shuffle(ids);

        //Names
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        ArrayList<String> names = new ArrayList<String>();

        for (int i = 0; i < 50000; i++) {
            int n = Util.generateRandomNumber(10, 20);
            StringBuilder sb = new StringBuilder(n);

            for (int j = 0; j < n; j++) {
                int index = (int) (string.length() * Math.random());
                sb.append(string.charAt(index));
            }
            names.add(sb.toString());
        }

        //Ages
        ArrayList<Integer> ages = new ArrayList<Integer>();
        for (int i = 0; i < 50000; i++) {
            ages.add(Util.generateRandomNumber(10, 70));
        }

        //Genders
        ArrayList<String> list = new ArrayList<String>();
        list.add("Male");
        list.add("Female");

        ArrayList<String> genders = new ArrayList<String>();
        for (int i = 0; i < 50000; i++) {
            genders.add(list.get(new Random().nextInt(list.size())));
        }

        //CountryCodes
        ArrayList<Integer> countryCodes = new ArrayList<Integer>();
        for (int i = 0; i < 50000; i++) {
            countryCodes.add(Util.generateRandomNumber(1, 10));
        }

        //Salaries
        ArrayList<Integer> salaries = new ArrayList<Integer>();
        for (int i = 0; i < 50000; i++) {
            salaries.add(Util.generateRandomNumber(100, 10000));
        }


        // Open/Create the file.
        File file = new File("customers.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < 50000; i++) {
            bw.write((ids.get(i)) + "," + (names.get(i)) + "," + (ages.get(i)) + "," + (genders.get(i)) + "," + countryCodes.get(i) + "," + (salaries.get(i)));
            bw.newLine();
        }

        bw.close();
        fw.close();

    }

}
