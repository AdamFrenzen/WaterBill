public class SingleFamily extends Customer {
    final double SINGLE_BASE = 13.21;
    final int SINGLE_TIER1 = 7000;
    final double SINGLE_TIER1_COST = 2.04;
    final int SINGLE_TIER2 = 6000;
    final double SINGLE_TIER2_COST = 2.35;
    final double SINGLE_TIER3_COST = 2.70;

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
}
