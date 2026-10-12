import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleFamily extends Customer {
    final double SINGLE_BASE = 13.21;
    final int SINGLE_TIER1 = 7000;
    final double SINGLE_TIER1_COST = 2.04;
    final int SINGLE_TIER2 = 6000;
    final double SINGLE_TIER2_COST = 2.35;
    final double SINGLE_TIER3_COST = 2.70;

    private boolean lowIncome;

    public boolean getLowIncome() {
        return lowIncome;
    }

    public void setLowIncome(boolean lowIncome) {
        this.lowIncome = lowIncome;
    }

    @Override
    public void customerInput() {
        super.customerInput();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            System.out.print("Enter low income status (true/false): ");
            setLowIncome(Boolean.parseBoolean(bufferedReader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateBill() {
        if (getGallonsUsed() <= SINGLE_TIER1) {
            bill = SINGLE_BASE + getGallonsUsed() * (SINGLE_TIER1_COST / GALLONS);
        } else if (getGallonsUsed() <= TIER2_CUTOFF) {
            bill = SINGLE_BASE + SINGLE_TIER1 * (SINGLE_TIER1_COST / GALLONS)
                    + (getGallonsUsed() - SINGLE_TIER1) * (SINGLE_TIER2_COST /
                    GALLONS);
        } else {
            bill = SINGLE_BASE + SINGLE_TIER1 * (SINGLE_TIER1_COST / GALLONS)
                    + SINGLE_TIER2 * (SINGLE_TIER2_COST / GALLONS)
                    + (getGallonsUsed() - TIER2_CUTOFF) * (SINGLE_TIER3_COST /
                    GALLONS);
        }
    }

    public void applyDiscount() {
        if (lowIncome) {
            bill = bill * 0.90;
        }
    }
}
