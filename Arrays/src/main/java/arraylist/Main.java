package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryInstance = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            groceryInstance.printArrray();
            System.out.println(" Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryInstance.printArrray();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add a item to the list");
        System.out.println("\t 3 - To modify a item to the list.");
        System.out.println("\t 4 - To remove a item to the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit de application");
    }

    public static void addItem() {
        System.out.println(" Please enter the grocery item: ");
        groceryInstance.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem () {
        System.out.println("Enter item number :");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter replacement Item.");
        String newItem = scanner.nextLine();
        groceryInstance.modifyGroceryItem(itemNumber - 1, newItem);
    }

    public static void removeItem () {
        System.out.println("Enter item number :");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        groceryInstance.remove(itemNumber -1 );
    }

    public static void searchForItem() {
        System.out.println("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryInstance.findItem(searchItem) != null )
        {
            System.out.println("Found " + searchItem + " in our grocery list ");
        } else {
            System.out.println("The item is not in our grocery List.");
        }

    }
}
