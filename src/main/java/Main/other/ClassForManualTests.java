package Main.other;

/**
 * TODO: NOT TO RUN THIS
 */
public class ClassForManualTests {

    @ManualTestRunner.ManualTest
    public static void test1(){
        throw new RuntimeException("Boom");
    }
    @ManualTestRunner.ManualTest
    public static void test2(){

    }
    @ManualTestRunner.ManualTest
    public static void test3(){
        throw new RuntimeException("Crash");
    }
    @ManualTestRunner.ManualTest
    public static void test4(){

    }
    @ManualTestRunner.ExceptionManualTest(ArithmeticException.class)
    public static void test5(){
        int i = 0;
        i = i / i;
    }
    @ManualTestRunner.ExceptionManualTest(ArithmeticException.class)
    public static void test6(){
        int[] a = new int[1];
        int i = a[2];
    }
    @ManualTestRunner.ExceptionManualTest(ArithmeticException.class)
    public static void test7(){}

}
