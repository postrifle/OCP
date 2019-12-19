package OCP8.concurrency;

import java.util.concurrent.*;

public class IntroducingCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
//            Runnable as an argument, so try/catch block is needed
            service.submit(()-> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
//            Callable as an argument(return), so there is no need try/catch block
            service.submit(()->{Thread.sleep(1000); return 42;});
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
