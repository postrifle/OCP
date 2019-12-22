package OCP8.misc.designpatterns;

public class SingletonExample {
    private final static SingletonExample instance;

    static {
        instance = new SingletonExample();
    }

    private SingletonExample() {
    }
    public static SingletonExample getInstance(){
        return instance;
    }

}
