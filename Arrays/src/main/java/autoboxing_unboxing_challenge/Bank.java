package autoboxing_unboxing_challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private ArrayList<Branches> branches = new ArrayList<Branches>();
    private Scanner scanner =new Scanner(System.in);

    public Bank(ArrayList<Branches> branches) {
        this.branches = branches;
    }

    public ArrayList<Branches> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branches> branches) {
        this.branches = branches;
    }

    public void newBranch() {
        System.out.println("Please enter the name of the new branch");
        String name = scanner.next();
        branches.add(new Branches(name, new ArrayList<Customer>()));
    }

    public void addCustomerToBranch() {
        System.out.println("Please enter the branch name :");
        String branchName = scanner.next();
        int indexBranch = buscarBranch(branchName);
        Branches.addCustomer(indexBranch, branches.get(indexBranch).getCustomers());

    }

    public void addTransaction() {
        System.out.println("Please enter the branch name :");
        String branchName = scanner.next();
        int indexBranch = buscarBranch(branchName);
        Branches.addTransaction(indexBranch, branches.get(indexBranch).getCustomers());

    }

    public void showCustomerInBranch() {
        System.out.println("Please enter the branch name :");
        String branchName = scanner.next();
        int indexBranch = buscarBranch(branchName);
        ArrayList<Customer> customers= branches.get(indexBranch).getCustomers();

        if (indexBranch >= 0) {
            for (int i=0; i< customers.size(); i++) {
                System.out.println("1 " +  customers.get(i).getName());
            }
        }
    }

    public void showCustomerwithTransaccionInBranch() {
        System.out.println("Please enter the branch name :");
        String branchName = scanner.next();
        int indexBranch = buscarBranch(branchName);
        ArrayList<Customer> customers= branches.get(indexBranch).getCustomers();

        if (indexBranch >= 0) {
            for (int i=0; i < customers.size(); i++) {
                System.out.println("The customer "+ customers.get(i).getName() + " has the next transactions");
                for (int j = 0; j < customers.get(i).getTransactions().size(); j++) {
                    System.out.println(i + " --> " + customers.get(i).getTransactions().get(j));
                }
            }
        }
    }

    private  int buscarBranch(String branchName) {

        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }


}
