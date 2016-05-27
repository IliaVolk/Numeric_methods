package NumericMethods;

public class Function{

    private Expression expression;


    public Function(Expression expression) {
        this.expression = expression;
    }
    public double f(double x){
        return expression.f(x);
    }
    public double derivative(double x){
        return Num.derivative(expression, x);
    }
}