package NumericMethods;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.text.DecimalFormat;

import static NumericMethods.Num.*;
import static java.lang.Math.*;

public class Main {

    public static double iteration(Function f, double x0, double eps, double q){
        double xn_1 = x0;
        double xn = 0;
        for (int i = 1;; i++){

            xn = f.f(xn_1);
            System.out.println(String.format(
                    "X%d = %2.3f, |%2.3f - %2.3f| = %2.3f", i, xn, xn, xn_1, abs(xn-xn_1)
            ));
            //p("x" + (i) + " = " + format(xn) +
                    //", f(x" + i + ") = " + format(f.f(xn_1)) +
            //        ", |xn_1 - xn| = " + format(abs(xn_1 - xn)));
            /*System.out.println(String.format(
                    "end condition = ((1-%2.3f)/%2.3f) * 0.01 = %2.3f", q,q, ( (1- q) / q) * eps
            ));*/
            if (abs(xn_1 - xn) < ( (1- q) / q) * eps) break;
            xn_1 = xn;
        }
        return xn;

    }
    public static double iteration(Function f, double x0){
        return iteration(f,x0, 0.01, 0.95);
    }


    static void checkFunc(Function f, double a, double b){
        for (double x = a; x < b; x += 0.01){
            p(      "x = "      +format(x)+
                    ", f(x) = " + format(f.f(x)) +
                    ", df/dx = " +format(f.derivative(x)));
        }
    }
    static double square(double d){
        return d*d;
    }

    static double tangent(Function fi, double M2, double m1, double x0, double eps){
        double xn_1 = x0;//x (n-1)
        double xn = 0;
        double valueThatMustBeLowerThenEpsilon;
        System.out.println("x0 = "+x0);
        for(int i = 1;;i++){
            xn = fi.f(xn_1);
            valueThatMustBeLowerThenEpsilon = (M2/(2*m1))*square(Math.abs(xn_1 - xn));
            p("x" + (i ) + " = " + format(xn) +
                    ", f(x" + (i-1) + ") = " + format(fi.f(xn_1)) +
                    ", (M2/(2*m1))*|xn_1-xn|^2 = " + format(valueThatMustBeLowerThenEpsilon));

            if (valueThatMustBeLowerThenEpsilon < eps) break;
            xn_1 = xn;
        }
        return xn;
    }
    public static void main(String[] args) {
        Function f = new Function(x ->
                (x - 3) * (x - 3) - log(x) - x
        );
        Function f2 = new Function(x ->
                exp((x - 3) * (x - 3))
        );
        Function f3 = new Function(x -> //Функция для корня 2.130 метода итараций
                (x * x + 9 - log(x)) / 6        //System.out.println("result = "+iteration(f3, 1.5));
        );
        Function f4 = new Function(x -> //Функция для корня 4.19 метода итераций
                sqrt(log(x) + 6 * x - 9)    //System.out.println("result = "+iteration(f4, 5));
        );
        ////////итерации заканчиваются
        //касательные начинаются
        Function fi = new Function(x ->             //Функция для корня 2.130 метода касательных
                x - (((x - 3) * (x - 3) - log(x))) / (2 * x - 6 - 1 / x)//System.out.println("result = "+tangent(fi, 3.2, 0.25, 1, 0.005));
                //Функция для корня 4.19 метода касательных
        );                                          //System.out.println("result = "+tangent(fi, 6.1, 0.6, 6, 0.005));

        System.out.println("result = " + tangent(fi, 3, 0.6, 6, 0.01));
    }
}
