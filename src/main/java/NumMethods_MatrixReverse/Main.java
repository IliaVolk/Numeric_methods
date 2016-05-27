package NumMethods_MatrixReverse;

public class Main {
    static {

    }
    static double[][] matrix = {
            {5.68, 1.12, 0.95, 1.32, 0.83},
            {1.12, 3.78, 2.12, 0.57, 0.91},
            {0.95, 2.12, 6.63, 1.29, 1.57},
            {1.32, 0.57, 1.29, 4.07, 1.25},
            {0.83, 0.91, 1.57, 1.25, 5.71}
    };

    static double[][] doubleMatrix = new double[5][10];

    static void copyMatrix(double[][] from, double[][] to){
        for (int i = 0; i < from.length; i++){
            System.arraycopy(from[i], 0, to[i], 0, from[i].length);
        }
    }
    static void prepareDoubleMatrix() {
        for (int i = 0, j = 5; i < doubleMatrix.length; i++, j++){
            doubleMatrix[i][j] = 1;
        }
    }
    static void printDoubleMatrix(){
        for (int i = 0; i < doubleMatrix.length; i++){
            for (int j = 0; j < doubleMatrix[i].length; j++){
                System.out.print(String.format(" %4.2f ",doubleMatrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    static void divideRowOfDoubleMatrixByValue(int row, double value){
        for (int i = 0; i < doubleMatrix[row].length; i++){
            doubleMatrix[row][i] /= value;
        }
    }
    static void subscribeRowFromOtherRowWithMultiplicatinOfDoubleMatrix(
            int diminishing, int subtrahend, double multFactor){//зменшуване, від'ємник
        for (int i = 0; i < doubleMatrix[diminishing].length; i++){
            doubleMatrix[diminishing][i] -= doubleMatrix[subtrahend][i] * multFactor;
        }
    }

    static void makeGaussForwardWalk(){
        for (int i = 0; i < doubleMatrix.length; i++){
            divideRowOfDoubleMatrixByValue(i, doubleMatrix[i][i]);
            //printDoubleMatrix();
            for (int j = i+1; j < doubleMatrix.length; j++){
                subscribeRowFromOtherRowWithMultiplicatinOfDoubleMatrix(
                        j, i, doubleMatrix[j][i]/doubleMatrix[i][i]
                );
                //printDoubleMatrix();
            }
            printDoubleMatrix();
        }
    }

    static void makeGaussBackWalk(){
        for (int i = doubleMatrix.length-1; i >=0; i--){
            for (int j = i-1; j >=0; j--){
                subscribeRowFromOtherRowWithMultiplicatinOfDoubleMatrix(
                        j, i, doubleMatrix[j][i]/doubleMatrix[i][i]
                );
                //printDoubleMatrix();
            }
            printDoubleMatrix();
        }
    }
    public static void main(String[] args) {
        //нахождение обратной матрицы
        copyMatrix(matrix, doubleMatrix);
        prepareDoubleMatrix();
        makeGaussForwardWalk();
        makeGaussBackWalk();
    }



}
