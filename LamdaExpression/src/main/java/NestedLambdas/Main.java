package NestedLambdas;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        String result = anotherClass.doSomething();
        System.out.println(result);


        ArrayList<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

        listInteger.forEach(integer  -> {
            System.out.println(integer);
        });


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}
