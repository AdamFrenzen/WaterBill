public class Duplex extends Customer {
    final double DUPLEX_BASE = 15.51;
    final int DUPLEX_TIER1 = 9000;
    final double DUPLEX_TIER1_COST = 1.97;
    final int DUPLEX_TIER2 = 4000;
    final double DUPLEX_TIER2_COST = 2.26;
    final double DUPLEX_TIER3_COST = 2.60;

    public void calculateBill() {
        if (getGallonsUsed() <= DUPLEX_TIER1) {
            bill = DUPLEX_BASE + getGallonsUsed() * (DUPLEX_TIER1_COST / GALLONS);
        } else if (getGallonsUsed() <= TIER2_CUTOFF) {
            bill = DUPLEX_BASE + DUPLEX_TIER1 * (DUPLEX_TIER1_COST / GALLONS)
                    + (getGallonsUsed() - DUPLEX_TIER1) * (DUPLEX_TIER2_COST /
                    GALLONS);
        } else {
            bill = DUPLEX_BASE + DUPLEX_TIER1 * (DUPLEX_TIER1_COST / GALLONS)
                    + DUPLEX_TIER2 * (DUPLEX_TIER2_COST / GALLONS)
                    + (getGallonsUsed() - TIER2_CUTOFF) * (DUPLEX_TIER3_COST /
                    GALLONS);
        }
    }
}
