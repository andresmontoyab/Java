package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ISaveable tim = new Player("Tim", 15,25);
        System.out.println(tim.toString());
        savedObject(tim);

        ((Player) tim).setHitPoints(8);
        System.out.println(tim);

        ((Player) tim).setWeapon("Stormbringer");
        savedObject(tim);
        loadObject(tim);
        System.out.println(tim);

        ISaveable wereWolf = new Monster("WereWolf", 20, 40);
        System.out.println(wereWolf);
        savedObject(wereWolf);
    }

    public static List<String> readvalues() {
        List<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Please Select a option\n" +
                            " 0 -> Quit \n" +
                            " 1 -> Add String");

        while(!quit) {
            System.out.println("Choose a option");
            int optionSelected = scanner.nextInt();
            scanner.nextLine();

            switch (optionSelected) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Please enter the new String");
                    String stringInput = scanner.nextLine();
                    values.add(stringInput);
                    break;
            }

        }

        return values;

    }

    public static void savedObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i ++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage devices.");
        }
    }

    public static void loadObject(ISaveable objectLoad) {
        List<String> values = readvalues();
        objectLoad.read(values);
    }
}
