package OCP8.misc.designpatterns;

public class DesignPatternsTester {
    public static void main(String[] args) {
//        testing singleton pattern
        LazyInitializationSingletonExample singleton_1 = LazyInitializationSingletonExample.getInstance();
        LazyInitializationSingletonExample singleton_2 = LazyInitializationSingletonExample.getInstance();
        System.out.println(singleton_1==singleton_2);

//        Using Build pattern
        BuilderPatternExample bpe = new BuilderPatternExample.Builder("Param_1").
                setOptionalBoolean(true).
                setOptionalChar('A').
                setOptionalDouble(3.14).
                setOptionalInt(42).build();

        System.out.println(bpe.toString());




    }
}
