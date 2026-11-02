import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
//        SingleFamily customer = new SingleFamily();
//        customer.customerInput();
//        customer.generateBill();
//
//        Duplex duplex = new Duplex();
//        duplex.customerInput();
//        duplex.generateBill();


        Duplex dup2 = new Duplex("adam", 6000);
        SingleFamily sf2 = new SingleFamily("bob", 6000, true);

        dup2.generateBill();
        sf2.generateBill();

        System.out.println(Customer.getAllCustomers());


//        for (Customer c : Customer.getAllCustomers()) {
//            System.out.println(c);
//        }

//        for (int i = 0; i < Customer.getAllCustomers().size(); i++) {
//            System.out.println(Customer.getAllCustomers().get(i));
//        }
    }
}
