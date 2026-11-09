import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataValidationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public abstract class Customer implements Comparable<Customer> {
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
            throw new DataValidationException("Must have a name");
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
            try {
                setName(bufferedReader.readLine());
            } catch (DataValidationException e) {
                System.out.print(e);
            }
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

    public static void sortByBill() {
//        Collections.sort(getAllCustomers());

        getAllCustomers().sort(Comparator.comparingDouble(Customer::getBill));
    }

    @Override
    public int compareTo(Customer o) {
        return Double.compare(this.getBill(), o.getBill());
    }

    public static void statReport() {
        try {
            System.out.println(getHighestCustomer());
        } catch (NoCustomerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void awardLoyaltyReward() {
        try {
            System.out.println("Reward award: " + getHighestCustomer());
        } catch (NoCustomerException e) {
            System.out.println("There are no rewards to award");
        }
    }

    public static Customer getHighestCustomer() throws NoCustomerException {
        if (getAllCustomers().isEmpty()) {
            throw new NoCustomerException("No Customer exists");
        }

        try {
            Customer max = getAllCustomers().get(0);

            for (Customer c : getAllCustomers()) {
                if (c.getBill() > max.getBill()) {
                    max = c;
                }
            }

            return max;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No customers");
            return null;
        }
    }
}
