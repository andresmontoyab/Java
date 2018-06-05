package LambdaExpression;

public class Main {

    public static void main(String[] args) {
        new Thread(() ->  System.out.println("Im in the runnable")).start();
        MathAverage ma = (firstValue, secondValue) -> (firstValue + secondValue)/2;
        new UseLambda((a, b) -> {
            System.out.println("Im in the Lambda");
            return (a+b)/2;
        },5,6);

        usingInterface((firstValue, secondValue) -> (firstValue + secondValue)/2);
        usingInterface(ma);
    }

    public static void usingInterface(MathAverage ma) {
        ma.calculateAverage(10, 11);
    }
}
