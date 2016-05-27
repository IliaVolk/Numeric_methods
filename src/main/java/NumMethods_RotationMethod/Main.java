package NumMethods_RotationMethod;


import static java.lang.Math.sqrt;

public class Main {

    static double[][] A = {
            {8.825, 2.180, 5.684},
            {-1.351, 10.834, 5.224},
            {2.489, -0.459, 6.811}
    };
    static double[] b = {
            50.11,
            50.37,
            31.96
    };
    static double square(double n){
        return n*n;
    }
    static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(String.format(" %4.3f ", m[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
    static void printVector(double[] v){
        for (int i = 0; i < 3; i++){
            System.out.println(v[i]);
        }
        System.out.println();
    }
    static void printA(){
        System.out.println("Matrix A: ");
        printMatrix(A);
    }
    static void printB(){
        System.out.println("Vector b: ");
        printVector(b);
    }
    static void oneIteration(int row, int col){
        //base index = col!!
        System.out.println("row = "+row + " col = " + col);
        String sqrtInDenominatorString = String.format(
            "sqrt (%2.3f^2 + %2.3f^2)", A[col][col], A[row][col]);
        double sqrtInDenominator = sqrt(//sqrt = squareRoot
                square(A[col][col]) +
                square(A[row][col])
        );

        double c = A[col][col] / sqrtInDenominator;
        double s = A[row][col] / sqrtInDenominator;
        System.out.println(String.format(
                "c = %2.3f / "+sqrtInDenominatorString + " = %2.3f", A[col][col], c
        ));
        System.out.println(String.format(
                "s = %2.3f / "+sqrtInDenominatorString + " = %2.3f", A[row][col], s
        ));
        //System.out.println(square(c) + square(s));
        //System.out.println(c * A[row][col] - s * A[col][col]);
        for(int j = 0; j < A[col].length; j++){
            double newABaseJ = c*A[col][j] + s*A[row][j];
            double newARowJ = -s*A[col][j] + c*A[row][j];
            System.out.println(String.format(
                    "A[%d][%d] = %2.3f * %2.3f + %2.3f * %2.3f = %2.3f",col,j, c, A[col][j], s,A[row][j], newABaseJ
            ));
            System.out.println(String.format(
                    "A[%d][%d] = %2.3f * %2.3f + %2.3f * %2.3f = %2.3f",row,j, -s, A[col][j], c,A[row][j], newARowJ
            ));
            A[col][j] = newABaseJ;
            A[row][j] = newARowJ;

        }
        double newBCol = c*b[col] + s*b[row];
        double newBRow = -s*b[col] + c*b[row];
        System.out.println(String.format(
                "b[%d] = %2.3f * %2.3f + %2.3f * %2.3f = %2.3f", col, c, b[col], s, b[row], newBCol
        ));
        System.out.println(String.format(
                "b[%d] = %2.3f * %2.3f + %2.3f * %2.3f = %2.3f", row, -s, b[col], c, b[row], newBRow
        ));
        b[col] = newBCol;
        b[row] = newBRow;



    }
    static void rotationForwardWalk(){
        printA();
        printB();
        for (int i = 0; i < A.length-1; i++){
            for (int j = i+1; j < A.length; j++){
                oneIteration(j,i);
                printA();
                printB();
            }
        }
    }
    static void rotationBackWalk(){

    }
    public static void main(String[] args) {
        rotationForwardWalk();
        System.out.println(b[2]/A[2][2]);
    }
}
