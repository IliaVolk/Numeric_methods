package NumMethods_SetOfEquations;

import org.junit.Test;

import static NumMethods_SetOfEquations.Main.*;
public class MainTest {

    //@Test
    public void testOperations(){
        B = new double[][]{
                {1,1,1},
                {2,2,2},
                {3,3,3}
        };
        c = new double[]{30,20,10};
        printVector(nextIterationVector(new double[]{1, 1, 1}));
    }
    @Test
    public void testMaxSumOfVectors(){
        double[] v1 = new double[]{1,2,3};
        double[] v2 = new double[]{3,1,0};
        System.out.println(maxByIOfVectors(v1,v2));
    }
}
