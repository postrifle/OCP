package OCP8.concurrency;

import java.util.concurrent.*;

public class SchedulingTasks {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        ScheduledFuture<String> result = service.schedule(() -> "task_1", 5, TimeUnit.SECONDS);
        System.out.println(result.get());
        service.schedule(() -> service.shutdown(), 20, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> System.out.println("FixedRate"), 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> System.out.println("Delays"), 4, 4, TimeUnit.SECONDS);
    }
}
