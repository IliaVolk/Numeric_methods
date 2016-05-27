package Main.other;

public interface InterfaceOfStaticGeneratedClass {
    public static InterfaceOfStaticGeneratedClass getInstance(){
        return new StaticGeneratedClassImplementation1();
    }
    public String method();
}
