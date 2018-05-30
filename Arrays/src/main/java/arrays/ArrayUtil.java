package arrays;

import java.util.Scanner;

public class ArrayUtil {

    private static Scanner scanner = new Scanner(System.in);


    public static int[] createArray(int number) {
        System.out.println("Enter " + number + " integers values .\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length ; i ++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.println("In the position :" + i + "the value is :" + array[i]);
        }
    }

    public static double arrayAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length ; i++ )
        {
            sum += array[i];
        }
        return (sum/array.length);
    }

    public static int[] descOrderArray(int[] array) {

        int valMenorPorIteraccion;
        int valAuxiliar;
        for (int i = array.length - 1; i > 0 ; i --) {
            valMenorPorIteraccion = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] < valMenorPorIteraccion)
                {
                    System.out.println("Se cambio " + array[j] + " por "+ valMenorPorIteraccion);
                    valAuxiliar = valMenorPorIteraccion;
                    valMenorPorIteraccion = array[j];
                    array[j] = valAuxiliar;
                }
                array[i] = valMenorPorIteraccion;
            }
        }
        return  array;
    }
 }
