package OCP8.concurrency.forkjointask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample extends RecursiveTask<Double> {
    int start, end;
    Double[] weight;
int availableProc = Runtime.getRuntime().availableProcessors();
    public RecursiveTaskExample(Double[] weight, int start, int end) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    protected Double compute() {
        if (end-start<=weight.length/availableProc){
            double sum=0;
            for (int i = start; i < end; i++) {
                weight[i] = (double) new Random().nextInt(100);
                System.out.println("weighted : "+i);
                sum+=weight[i];
            }
            return sum;
        }else{
            int mid =start+(end-start)/2;
            System.out.println("[start="+start+" mid="+mid+" end="+end);
            ForkJoinTask<Double> otherTask = new RecursiveTaskExample(weight, start, mid).fork();
            return new RecursiveTaskExample(weight, mid, end).compute()+otherTask.join();
        }
    }

    public static void main(String[] args) {
        Double[] weight = new Double[20];
        ForkJoinTask<Double> task = new RecursiveTaskExample(weight, 0, weight.length);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println("SUM = "+sum);
    }
}
