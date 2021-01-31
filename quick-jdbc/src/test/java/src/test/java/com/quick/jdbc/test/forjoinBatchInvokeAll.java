package src.test.java.com.quick.jdbc.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class forjoinBatchInvokeAll extends RecursiveTask<Integer> {

    private static final Integer THRESHOLD = 1000;
    private int start;
    private int end;
    public forjoinBatchInvokeAll(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        Integer sum = 0;
        boolean isOk = end - start <= THRESHOLD;
        if(isOk) {
            for(int i = start; i <= end; i ++) {
                sum += i;
            }
//            System.out.println(String.format("compute %d-%d = %d", start, end, sum));
            return sum;
        }

        //除以2
        int middle = (end + start) / 2;
        //子任务递归
//        System.out.println(String.format("fork %d-%d => %d-%d&%d-%d", start, end, start, middle - 1, middle, end));
        forjoinBatchInvokeAll sumSubTask = new forjoinBatchInvokeAll(start, middle - 1);
        forjoinBatchInvokeAll sumSubTask1 = new forjoinBatchInvokeAll(middle, end);

        //fork子任务
        invokeAll(sumSubTask, sumSubTask1);

        //join子任务
        Integer join = sumSubTask.join();
        Integer join1 = sumSubTask1.join();

        sum = join + join1;
        //计算结果
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool fjp2 = new ForkJoinPool();
        forjoinBatchInvokeAll forjoinBatchInvokeAll = new forjoinBatchInvokeAll(0, 100000);
        long begin3 = System.currentTimeMillis();
        Integer invoke = fjp2.invoke(forjoinBatchInvokeAll);
        long end3 = System.currentTimeMillis();
        //计算结果2为 sum = 705082704,计算时长为1611477793947-1611477793962---  15ms
        System.out.println("计算结果2为 sum = " + invoke + ",计算时长为" + begin3 + "-" + end3 + "---  " + (end3 - begin3) + "ms");
    }
}
