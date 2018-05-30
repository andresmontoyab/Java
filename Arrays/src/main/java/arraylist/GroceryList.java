package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {
    private ArrayList<String> arrayString = new ArrayList<String>();

    public void addGroceryItem (String item) {
        arrayString.add(item);
    }

    public void printArrray() {
        System.out.println("You have a ArrayList with " + arrayString.size() + " fields");
        for (int i = 0; i < arrayString.size(); i++) {
            System.out.println("The value of the position number " + i + " is "+ arrayString.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        arrayString.set(position, newItem);
        System.out.println("Grocery Item has been modified.");
    }

    public void remove(int position) {
        arrayString.remove(position);
        System.out.println("The position " + position + " has been removed.");
    }

    public String findItem(String searchItem) {
        boolean exist = arrayString.contains(searchItem);
        int position = arrayString.indexOf(searchItem);
        if (position >= 0) {
            return arrayString.get(position);
        }

        return null;
    }
}
