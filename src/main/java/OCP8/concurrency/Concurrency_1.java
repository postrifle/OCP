package OCP8.concurrency;

import java.util.concurrent.*;

public class Concurrency_1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService service;
        service = Executors.newSingleThreadExecutor();
        try {
            System.out.println("main begin");
            service.execute(() -> System.out.println("first task"));
            service.execute(() -> System.out.println("Second task"));
            Callable<Integer> task = () -> Runtime.getRuntime().availableProcessors();
            Future<Integer> result1 = service.submit(() -> Runtime.getRuntime().availableProcessors());
            System.out.println("AVAILABLE PROCESSORS :  " + result1.get());
            Future<String> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    if (i % 70 == 0) System.out.println("i= " + i);
                }
                return "THE END;";
            });
            System.out.println("RESULT : " + result.get(10, TimeUnit.SECONDS));
        } finally {
            if (service != null) service.shutdown();
        }
        System.out.println("main finishes");
    }
}
