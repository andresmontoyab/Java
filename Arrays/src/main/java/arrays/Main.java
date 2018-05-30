package arrays;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        int[] arrayInt = {1, 2, 3, 4};

        System.out.println(arrayInt[0]);
        System.out.println(arrayInt[1]);
        System.out.println(arrayInt[2]);
        System.out.println(arrayInt[3]);

        Object[] objects = new Object[5];
        objects[0] = "Hi There";
        objects[1] = true;
        objects[2] = 4l;
        objects[3] = new Integer(3);

        System.out.println(objects[0].toString());
        System.out.println(objects[1].toString());
        System.out.println(objects[2].toString());
        System.out.println(objects[3].toString());

        String[] strings = {"Carlos", "Andres", "Sofia", "Sara"};

        int[] array = ArrayUtil.createArray(5);
        ArrayUtil.arrayAverage(array);
        ArrayUtil.printArray(array);
        System.out.println("Ordenar Vector");
        ArrayUtil.descOrderArray(array);
        ArrayUtil.printArray(array);
    }


}
