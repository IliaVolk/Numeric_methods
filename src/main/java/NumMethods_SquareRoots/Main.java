package NumMethods_SquareRoots;

import static java.lang.Math.sqrt;

public class Main {

    static double[][] A = {
            {5.68, 1.12, 0.95, 1.32, 0.83},
            {1.12, 3.78, 2.12, 0.57, 0.91},
            {0.95, 2.12, 6.63, 1.29, 1.57},
            {1.32, 0.57, 1.29, 4.07, 1.25},
            {0.83, 0.91, 1.57, 1.25, 5.71}
    };
    static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(String.format(" %4.3f ", m[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
    static double square(double n){
        return n*n;
    }

    static void printL(){
        System.out.println("L: ");
        printMatrix(L);
    }
    static double[][] L = new double[5][5];
    static void p(String s){
        System.out.print(s);
    }
    static void p(double d){
        System.out.print(String.format(" %2.3f ",d));
    }
    static double sumForL_i_i(int i){
        double sum = 0;
        System.out.print("sum_i_i(i="+i+ ")= ");
        for (int p = 0; p < i; p++){
            sum += square(L[i][p]);
            p(L[i][p]);
            p("^");
            p(2);
        }
        System.out.print(" = ");
        p(sum);
        System.out.println();
        return sum;
    }
    static double sumForL_i_p_j_p(int i, int j){
        double sum = 0;
        System.out.print("sum_i_p_j_p(i="+i+" j="+j+") = ");
        for (int p = 0; p < i; p++){
            sum += L[i][p]*L[j][p];
            p(L[i][p]);
            p("*");
            p(L[j][p]);
        }
        System.out.print(" = ");
        p(sum);
        System.out.println();
        return sum;
    }
    //http://algowiki-project.org/ru/%D0%A0%D0%B0%D0%B7%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5_%D0%A5%D0%BE%D0%BB%D0%B5%D1%86%D0%BA%D0%BE%D0%B3%D0%BE_(%D0%BC%D0%B5%D1%82%D0%BE%D0%B4_%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82%D0%BD%D0%BE%D0%B3%D0%BE_%D0%BA%D0%BE%D1%80%D0%BD%D1%8F)
    static void createL(){
        L[0][0] = sqrt(A[0][0]);
        System.out.println(String.format("L[0][0] = sqrt(%2.3f) = %2.3f", A[0][0], sqrt(A[0][0])));
        for (int j = 1; j < A.length; j++){
            L[j][0] = A[j][0]/L[0][0];
            System.out.println(String.format(
                    "L[%d][0] = A[%d][0]/L[0][0] = %2.3f / %2.3f = %2.3f",
                    j,j,A[j][0],L[0][0], A[j][0]/L[0][0]
            ));
        }
        printL();
        for (int i = 1; i < A.length; i++){
            System.out.println(String.format("L[%d][%d] = sqrt(A[%d][%d] - sum_i_i", i,i,i,i));
            double sumForL_i_i = sumForL_i_i(i);
            L[i][i] = sqrt(A[i][i] - sumForL_i_i);
            System.out.println(String.format("L[%d][%d] = sqrt(%2.3f - %2.3f) = %2.3f",i,i, A[i][i],sumForL_i_i, L[i][i]));
            //System.out.println(" = "+ L[i][i]);
        //}
        //for (int i = 1; i < A.length; i++){
            for (int j = i+1; j < A.length; j++){
                System.out.println(String.format(
                        "L[%d][%d] = (A[%d][%d] - sum_i_p_j_p) / L[%d][%d] = "
               , j,i,j,i,i,i ));
                double sumForL_i_p_j_p = sumForL_i_p_j_p(i,j);
                L[j][i] = (A[j][i] - sumForL_i_p_j_p) / L[i][i];
                System.out.println(String.format(
                        "L[%d][%d] = (%2.3f - %2.3f)/%2.3f = %2.3f", j,i,
                        A[j][i], sumForL_i_p_j_p, L[i][i], L[j][i]
                ));
            }
            printL();
        }
    }

    public static void main(String[] args) {
        createL();
        printL();
        //System.out.println("A: ");
        //printMatrix(A);
        double product = 1;
        System.out.print("product = ");
        for (int i = 0; i < L.length; i++){
            product *= square(L[i][i]);
            System.out.print(String.format("%3.3f^2 * ", L[i][i]));
        }
        System.out.println(" = "+product);
    }
}
