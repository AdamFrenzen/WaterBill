import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Customer {
    final double SINGLE_BASE = 13.21;
    final int SINGLE_TIER1 = 7000;
    final double SINGLE_TIER1_COST = 2.04;
    final int SINGLE_TIER2 = 6000;
    final double SINGLE_TIER2_COST = 2.35;
    final double SINGLE_TIER3_COST = 2.70;

    final double DUPLEX_BASE = 15.51;
    final int DUPLEX_TIER1 = 9000;
    final double DUPLEX_TIER1_COST = 1.97;
    final int DUPLEX_TIER2 = 4000;
    final double DUPLEX_TIER2_COST = 2.26;
    final double DUPLEX_TIER3_COST = 2.60;

    final int TIER2_CUTOFF = 13000;
    final double GALLONS = 1000.0;

    String name;
    int gallonsUsed;
    int customerType;
    double bill;

    public void customerInput() {
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
    }

    public void calculateBill() {
        if (customerType == 1) {
            if (gallonsUsed <= SINGLE_TIER1) {
                bill = SINGLE_BASE + gallonsUsed * (SINGLE_TIER1_COST / GALLONS);
            } else if (gallonsUsed <= TIER2_CUTOFF) {
                bill = SINGLE_BASE + SINGLE_TIER1 * (SINGLE_TIER1_COST / GALLONS)
                        + (gallonsUsed - SINGLE_TIER1) * (SINGLE_TIER2_COST /
                        GALLONS);
            } else {
                bill = SINGLE_BASE + SINGLE_TIER1 * (SINGLE_TIER1_COST / GALLONS)
                        + SINGLE_TIER2 * (SINGLE_TIER2_COST / GALLONS)
                        + (gallonsUsed - TIER2_CUTOFF) * (SINGLE_TIER3_COST /
                        GALLONS);
            }
        } else {
            if (gallonsUsed <= DUPLEX_TIER1) {
                bill = DUPLEX_BASE + gallonsUsed * (DUPLEX_TIER1_COST / GALLONS);
            } else if (gallonsUsed <= TIER2_CUTOFF) {
                bill = DUPLEX_BASE + DUPLEX_TIER1 * (DUPLEX_TIER1_COST / GALLONS)
                        + (gallonsUsed - DUPLEX_TIER1) * (DUPLEX_TIER2_COST /
                        GALLONS);
            } else {
                bill = DUPLEX_BASE + DUPLEX_TIER1 * (DUPLEX_TIER1_COST / GALLONS)
                        + DUPLEX_TIER2 * (DUPLEX_TIER2_COST / GALLONS)
                        + (gallonsUsed - TIER2_CUTOFF) * (DUPLEX_TIER3_COST /
                        GALLONS);
            }
        }
    }

    public void printBill() {
        System.out.println("The bill is" + bill);
    }
}
