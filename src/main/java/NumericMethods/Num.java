package NumericMethods;

import java.text.DecimalFormat;

public class Num {

    private static double dx = 0.0000001;

    public static void setDx(double dx) {
        Num.dx = dx;
    }

    static DecimalFormat formatter = new DecimalFormat("####.#######");

    static String format(double d){
        return formatter.format(d);
    }
    public static void p(double number){
        System.out.println(formatter.format(number));
    }
    public static void p(String s){
        System.out.println(s);
    }
    public static void p(String message, double number){
        System.out.println(message + " " + formatter.format(number));
    }
    public static double derivative(Expression e, double x){
        return (e.f(x + dx)- e.f(x))/dx;
    }





}
