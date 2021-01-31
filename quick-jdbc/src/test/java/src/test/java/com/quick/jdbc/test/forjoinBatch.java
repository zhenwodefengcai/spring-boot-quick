package src.test.java.com.quick.jdbc.test;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class forjoinBatch extends RecursiveTask<Integer> {

    private static final Integer THRESHOLD = 10000;
    private int start;
    private int end;
    public forjoinBatch(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        Integer sum = 0;
        boolean isOk = (end - start) <= THRESHOLD;
        if(isOk) {
            for(int i = start; i <= end; i ++) {
                sum += i;
            }
            return sum;
        }

        int middle = (end + start) / 2;
        //子任务递归
        forjoinBatch sumSubTask = new forjoinBatch(start, middle);
        forjoinBatch sumSubTask1 = new forjoinBatch(middle + 1, end);

        //fork子任务
        sumSubTask.fork();
        sumSubTask1.fork();

        //join子任务
        Integer join = sumSubTask.join();
        Integer join1 = sumSubTask1.join();

        sum = join + join1;
        //计算结果
        return sum;
    }

//    @Test
//    public void  forjoinBatch() {
//        ForkJoinPool fjp2 = new ForkJoinPool();
//        forjoinBatch sumTask2 = new forjoinBatch(0, 100000);
//        long begin3 = System.currentTimeMillis();
//        Integer invoke = fjp2.invoke(sumTask2);
//        long end3 = System.currentTimeMillis();
//        System.out.println("计算结果3为 sum = " + invoke + ",计算时长为" + begin3 + "-" + end3 + "---  " + (end3 - begin3) + "ms");
//    }

    public static void main(String[] args) {
        ForkJoinPool fjp2 = new ForkJoinPool();
        forjoinBatch sumTask2 = new forjoinBatch(0, 100000);
        long begin3 = System.currentTimeMillis();
        Integer invoke = fjp2.invoke(sumTask2);
        long end3 = System.currentTimeMillis();
        //计算结果3为 sum = 705082704,计算时长为1611477520431-1611477520442---  11ms
        System.out.println("计算结果3为 sum = " + invoke + ",计算时长为" + begin3 + "-" + end3 + "---  " + (end3 - begin3) + "ms");
    }
}
