package NestedLambdas;

public class AnotherClass {

    public String doSomething() {
        int i = 0;
        UpperConcat uc = ((s1, s2) -> {
            System.out.println("The Lambda expression class is " + getClass().getSimpleName());
            System.out.println("Showing vbles of Another class " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        });

        System.out.println("The another class is " + getClass().getSimpleName());

        return Main.doStringStuff(uc,"String1", "String2");
    }
}
