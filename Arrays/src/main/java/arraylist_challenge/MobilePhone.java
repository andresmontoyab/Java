package arraylist_challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private static ArrayList<Contact> contacts = new ArrayList<Contact>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean quit;

    public static void startMenu() {
        quit = false;

        while (!quit) {
            System.out.println("Welcome to you Mobile Contacts, Please choose one option :");
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    showList();
                    break;
                case 2:
                    newContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit();
                    break;
            }

        }
    }

    public static void printMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - Show Menu Again");
        System.out.println("\t 1 - To print the list of contacts items");
        System.out.println("\t 2 - To add a contact to the list");
        System.out.println("\t 3 - To modify a contact to the list.");
        System.out.println("\t 4 - To remove a contact to the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit de application");
    }

    public static void showList() {

        System.out.println("The contact's list is :");
        for (int i = 0 ; i < contacts.size(); i++) {
            System.out.println(i+1 + " --> Name:" + contacts.get(i).getName() + " , number:" + contacts.get(i).getNumber());
        }
    }

    public static void newContact() {
        System.out.println("Please enter the name :");
        String name = scanner.next();
        System.out.println("Please enter the number");
        int number = scanner.nextInt();
        contacts.add(new Contact(name, number));
    }

    public static void updateExistingContact() {
        System.out.println("Please enter the contact to update :");
        String name = scanner.next();
        System.out.println("Please enter the new number :");
        int number = scanner.nextInt();
        Contact contactToUpdate = new Contact(name, number);

        int positionContact = searchContactInList(name);

        if (positionContact >= 0) {
            contacts.set(positionContact, contactToUpdate );
            System.out.println("The contact has been Updated.");
        } else {
            System.out.println("There's no a contact with this name.");
        }
    }

    public static void removeContact() {
        System.out.println("Please enter the contact name to delete.");
        String name = scanner.next();

        int positionContact = searchContactInList(name);

        if (positionContact >= 0) {
            contacts.remove(positionContact);
            System.out.println("The contact has been deleted.");
        } else {
            System.out.println("There's no a contact with this name.");
        }
    }

    public static void searchContact() {
        System.out.println("PLease enter the contact name to seacrh");
        String name = scanner.next();
        int position = searchContactInList(name);

        if (position >= 0) {
            System.out.println("The number  of " + name + " is " + contacts.get(position).getNumber());
        } else {
            System.out.println("There's no a contact with this name.");
        }
    }

    public static void quit() {
        System.out.println("The app is over.");
        quit = true;
    }


    private static int searchContactInList(String name) {
        int positionContact = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;

            }
        }
        return -1;
    }




}
