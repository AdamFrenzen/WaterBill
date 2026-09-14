import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Customer {
    String name;
    int gallonsUsed;
    int customerType;
    double bill;

    public void calculateBill() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            System.out.print("Enter Customer Name: ");
            name = bufferedReader.readLine();
            System.out.print("Enter Customer Type (1: SingleFamily, 2: Duplex): ");
            customerType = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Enter gallons used: ");
            gallonsUsed = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ////////

        if (customerType == 1) {
            if (gallonsUsed <= 7000) {
                bill = 13.21 + gallonsUsed * (2.04 / 1000.0);
            } else if (gallonsUsed <= 13000) {
                bill = 13.21 + 7000 * (2.04 / 1000.0)
                        + (gallonsUsed - 7000) * (2.35 / 1000.0);
            } else {
                bill = 13.21 + 7000 * (2.04 / 1000.0)
                        + 6000 * (2.35 / 1000.0)
                        + (gallonsUsed - 13000) * (2.70 / 1000.0);
            }
        } else {
            if (gallonsUsed <= 7000) {
                bill = 15.51 + gallonsUsed * (1.97 / 1000.0);
            } else if (gallonsUsed <= 13000) {
                bill = 15.51 + 9000 * (1.97 / 1000.0)
                        + (gallonsUsed - 9000) * (2.26 / 1000.0);
            } else {
                bill = 15.51 + 9000 * (1.97 / 1000.0)
                        + 4000 * (2.26 / 1000.0)
                        + (gallonsUsed - 13000) * (2.60 / 1000.0);
            }
        }

    }


}
