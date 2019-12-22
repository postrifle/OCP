package OCP8.concurrency.forkjointask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample extends RecursiveAction {
    Double[] weight;
    int start;
    int end;
    int availableProc = Runtime.getRuntime().availableProcessors();

    public RecursiveActionExample(Double[] weight, int start, int end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= availableProc) {
            for (int i = start; i < end; i++) {
                weight[i] = (double) new Random().nextInt(100);
                System.out.println("weighted : " + i);
            }
        } else {
            int mid = start+(end-start)/2;
            System.out.println("[start=" + start + " mid=" + mid + " end=" + end);
            invokeAll(new RecursiveActionExample(weight, start, mid), new RecursiveActionExample(weight, mid, end));
        }
    }

    public static void main(String[] args) {
        Double[] weight = new Double[20];
//        Create ForkJoinTask
        ForkJoinTask<?> task = new RecursiveActionExample(weight, 0, weight.length);
//        Create ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        Execute the task
        forkJoinPool.invoke(task);
        for (Double aDouble : weight) {
            System.out.println("Weight : "+aDouble);
        }
    }
}
