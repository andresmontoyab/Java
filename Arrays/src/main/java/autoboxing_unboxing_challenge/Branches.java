package autoboxing_unboxing_challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Branches {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private static final Scanner scanner =new Scanner(System.in);

    public Branches(String name, ArrayList<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public static boolean addCustomer(int indexBranch, ArrayList<Customer> customers) {
        if (indexBranch >= 0) {
            System.out.println("Please enter the name of the customer.");
            String name = scanner.next();
            System.out.println("Please enter de value of the initial transaction");
            Double initialTransacction = scanner.nextDouble();

            ArrayList<Double> transaction = new ArrayList<Double>();
            transaction.add(initialTransacction);
            Customer customer = new Customer(name, transaction );
            customers.add(customer);

            return true;
        }
        return false;
    }

    public static boolean addTransaction(int indexBranch, ArrayList<Customer> customers) {
        if (indexBranch >= 0) {
            System.out.println("Please enter the name of the customer.");
            String name = scanner.next();
            System.out.println("Please enter de value of the initial transaction");
            Double newTransaction = scanner.nextDouble();

            int indexCustomer = buscarCustomer(name, customers);

            customers.get(indexCustomer).getTransactions().add(newTransaction);

            return true;
        }
        return false;
    }

    private static int buscarCustomer(String nameCustomer, ArrayList<Customer> arrayCustomer) {
        for (int i = 0 ; i < arrayCustomer.size(); i++) {
            if (arrayCustomer.get(i).getName().equals(nameCustomer)) {
                return i;
            }
        }
        return -1;
    }
}
