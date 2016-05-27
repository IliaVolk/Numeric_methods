package NumMethods_MatrixReverse;

import org.junit.Test;
import static NumMethods_MatrixReverse.Main.*;
public class TestMatrix {

    @Test
    public void testMatrixCopy(){
        copyMatrix(Main.matrix, Main.doubleMatrix);
        prepareDoubleMatrix();
        printDoubleMatrix();
        divideRowOfDoubleMatrixRowByValue(0,doubleMatrix[0][0]);
        printDoubleMatrix();
        subscribeRowFromOtherRowWithMultiplicatinOfDoubleMatrix(
                1, 0, doubleMatrix[1][0] / doubleMatrix[0][0]
        );
        printDoubleMatrix();
    }
}
