import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Customer {
    final int TIER2_CUTOFF = 13000;
    final double GALLONS = 1000.0;

    private String name;
    private int gallonsUsed;
    private int customerType;
    private double bill;

    private static ArrayList<Customer> allCustomers = new ArrayList();

    public Customer() {
        System.out.println("this is a customer");
    }

    public Customer(String name, int gallonsUsed) {
        System.out.println("this is a customer second constructor");
        setName(name);
        setGallonsUsed(gallonsUsed);
        setCustomerType(customerType);
    }

    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public String getName() {
        return name;
    }

    public int getCustomerType() {
        return customerType;
    }

    public double getBill() {
        return bill;
    }

    public int getGallonsUsed() {
        return gallonsUsed;
    }

    public void setGallonsUsed(int gallonsUsed) {
        if (gallonsUsed < 0) {
            System.out.println("Gallons must be positive");
        } else {
            this.gallonsUsed = gallonsUsed;
        }
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public void setName(String name) {
        if (name.equals("") || name == null) {
            System.out.println("Must have a name");
        } else {
            this.name = name;
        }
    }

    protected void registerCustomer() {
        allCustomers.add(this);
    }

    public void customerInput() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            System.out.print("Enter Customer Name: ");
            name = bufferedReader.readLine();
//            System.out.print("Enter Customer Type (1: SingleFamily, 2: Duplex): ");
//            customerType = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Enter gallons used: ");
            setGallonsUsed(Integer.parseInt(bufferedReader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract double calculateBill();

    protected double applyDiscount(double calculatedBill) {
        return calculatedBill;
    }

    public void generateBill() {
        double calculated = calculateBill();
        this.bill = applyDiscount(calculated);

        // temp
        registerCustomer();
    }

    public void printBill() {
        System.out.println("The bill is " + bill);
    }

    @Override
    public String toString() {
        return "Name " + getName();
    }

    public static Customer getHighestCustomer() {

        return null;
    }
}
