package OCP8.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    void remoneAnimals() {
        System.out.println("one");
    }

    void cleanPen() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("two");
    }

    void addAnimals() {
        System.out.println("three");
    }

    void perfirmCleaning() {
        remoneAnimals();
        cleanPen();
        addAnimals();
    }

    void performCleaning(CyclicBarrier c) {
        try {
            remoneAnimals();
            c.await();
            cleanPen();
            c.await();
            addAnimals();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int availableProc = Runtime.getRuntime().availableProcessors();
        ExecutorService service = null;
        try {
            System.out.println("### Without CyclicBarrier");
            service = Executors.newFixedThreadPool(availableProc);
            CyclicBarrierExample example = new CyclicBarrierExample();
            for (int i = 0; i < availableProc; i++) {
                service.submit(() -> example.perfirmCleaning());
            }
            Thread.sleep(1000);
            System.out.println("### With CyclicBarrier");
            CyclicBarrier c = new CyclicBarrier(availableProc);
            for (int i = 0; i < availableProc; i++) {
                service.submit(()->example.performCleaning(c));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
