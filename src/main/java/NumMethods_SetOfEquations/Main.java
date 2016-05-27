package NumMethods_SetOfEquations;

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
    /*static double[][] A = {
            {10,1,-1},
            {1,10,-1},
            {-1,1,10}
    };
    static double[] b = {
            11,10,10
    };*/
    static double[] c = new double[3];
    static void prepareC(){
        for (int i = 0; i < 3; i++){
            c[i] = doubleMatrix[i][3];
            doubleMatrix[i][i] = 0;
        }
    }
    static void printC(){
        System.out.println("C = ");
        printVector(c);
    }
    static double[][] B = new double[3][3];
    static void prepareB(){
        for (int i = 0; i < B.length; i++){
            System.arraycopy(doubleMatrix[i], 0, B[i], 0, B.length);
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                B[i][j] = -B[i][j];
            }
        }
    }
    static void printB(){
        System.out.println("B = ");
        printMatrix(B);
    }

    static double[][] doubleMatrix = new double[3][4];


    static void prepareMatrix(){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                doubleMatrix[i][j] = A[i][j];
            }
            doubleMatrix[i][3] = b[i];
        }
        for (int i = 0; i < 3; i++) {
            divideRowOfDoubleMatrixRowByValue(i, doubleMatrix[i][i]);
        }
        prepareC();
        prepareB();
    }
    static void divideRowOfDoubleMatrixRowByValue(int row, double value){
        for (int i = 0; i < doubleMatrix[row].length; i++){
            doubleMatrix[row][i] /= value;
        }
    }
    static void printMatrix(double[][] m){
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                System.out.print(String.format(" %4.3f ",m[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
    static void printDoubleMatrix(){
        printMatrix(doubleMatrix);
    }
    static double[] nextIterationVector(double[] vector){
        double[] nextVector = new double[]{0,0,0};
        for (int i = 0; i < B.length; i++){
            System.out.print(String.format("[%d] = ", i));
            for (int j = 0; j < B[i].length; j++) {
                /*System.out.println(String.format(
                        "B[%d][%d] (%2.3f) * Xn[%d] (%2.3f) = (%2.3f)", i, j, B[i][j], j, vector[j], B[i][j] * vector[j]
                ));*/
                System.out.print(String.format(
                        "(%2.3f)", B[i][j]*vector[j]
                ));
                System.out.print(" + ");
                nextVector[i] += B[i][j] * vector[j];
            }
            System.out.print(String.format(
                    "(%2.3f)", c[i]
            ));
            nextVector[i] += c[i];
            System.out.println(String.format(
                    " = %2.3f", nextVector[i]
            ));
        }
        return nextVector;
    }
    static void printVector(double[] v){
        for (int i = 0; i < 3; i++){
            System.out.println(v[i]);
        }
        System.out.println();
    }
    static double maxByIOfVectors(double[] v1, double[] v2){
        double max = 0;
        double abs;
        //System.out.print("Finding max of |x_i_n - x_i_n-1|");
        System.out.print("max( ");
        for (int i = 0; i < v1.length; i++){
            abs = Math.abs(v1[i] - v2[i]);
            /*System.out.println(String.format(
                    "abs = |%2.3f - %2.3f| = %2.3f", v1[i], v2[i], abs
            ));*/
            System.out.print(String.format(" %2.5f ;", abs));
            if (abs > max) max = abs;
        }
        System.out.print(")\n");
        return max;
    }
    static void iteration(double eps){
        double q = 0.9;
        prepareMatrix();
        printB();
        printC();
        double[] xn_1 = c.clone();
        double[] xn;
        double endCondition;
        for (int i = 1; i < 30 ; i++) {
            System.out.println("Calculating vector X" + i);
            xn =  nextIterationVector(xn_1);
            endCondition = (q / (1 - q)) * maxByIOfVectors(xn_1, xn);

            System.out.println("Iteration #"+i+" end condition = " + endCondition);
            System.out.println("vector x"+(i-1)+" = ");
            printVector(xn_1);
            System.out.println("vector x"+(i)+" = ");
            printVector(xn);
            if (endCondition < eps) break;
            xn_1 = xn;
        }
    }
    public static void main(String[] args) {
        iteration(0.01);
    }
}
