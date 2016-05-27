package Main.other;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO: NOT TO RUN THIS
 */
public class ManualTestRunner {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface ManualTest{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface ExceptionManualTest{
        Class<? extends Exception> value();
    }

    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        Class testClass = ClassForManualTests.class;
        for (Method m : testClass.getDeclaredMethods()){
            if (m.isAnnotationPresent(ManualTest.class)){
                tests++;
                try{
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    System.out.println(m + " failed: " + throwable);
                } catch (Exception e) {
                    System.out.println("Invalid test:" + m);
                }
            }
        }
        System.out.println(String.format("Passed : %d, Failed : %d", passed, tests - passed));
    }
}
