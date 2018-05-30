package autoboxing_unboxing_challenge;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Branches> branches = new ArrayList<Branches>();

        Bank bank = new Bank(branches);
        bank.newBranch();
        bank.addCustomerToBranch();
        bank.addCustomerToBranch();
        bank.addCustomerToBranch();
        bank.addTransaction();
        bank.showCustomerInBranch();
        bank.showCustomerwithTransaccionInBranch();

    }
}
