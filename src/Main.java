public class Main {
    
    public static void main(String[] args) {
        SingleFamily customer = new SingleFamily();
        customer.calculateBill();
        customer.applyDiscount();

        Duplex duplex = new Duplex();

        TownHouse townHouse = new TownHouse();
        townHouse.calculateBill();
        townHouse.printBill();
    }
}
