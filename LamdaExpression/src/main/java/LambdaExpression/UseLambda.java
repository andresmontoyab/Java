package LambdaExpression;

public class UseLambda {

    MathAverage lambdaFunction;

    public UseLambda(MathAverage lambdaFunction, int a, int b) {
        lambdaFunction.calculateAverage(a, b);
        this.lambdaFunction = lambdaFunction;
    }
}
