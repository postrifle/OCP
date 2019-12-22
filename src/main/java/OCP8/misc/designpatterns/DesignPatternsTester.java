package OCP8.misc.designpatterns;

public class DesignPatternsTester {
    public static void main(String[] args) {
        LazyInitializationSingletonExample singleton_1 = LazyInitializationSingletonExample.getInstance();
        LazyInitializationSingletonExample singleton_2 = LazyInitializationSingletonExample.getInstance();
        System.out.println(singleton_1==singleton_2);
    }
}
