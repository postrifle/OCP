package OCP8.concurrency;

import java.util.concurrent.*;

public class IntroducingCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> {
                Thread.sleep(5000);
                return 41 + 1;
            });
            System.out.println(result.get());
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
