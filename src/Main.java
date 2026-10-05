public class Main {
    
    public static void main(String[] args) {
        Customer c = new Customer();
        c.customerInput();

        c.calculateBill();
        c.printBill();

        Customer c1 = new Customer("alice", 2000, 0);
    }
}
