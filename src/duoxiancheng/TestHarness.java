package duoxiancheng;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();//每个新生成的线程，在启动门出等待；
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();//每个线程任务执行完毕之后，结束门的数量减1；
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();//startGate减1，等于0，所有线程开始同时运行
        endGate.await();//主线程必须等子线程完毕执行结束之后，才继续运行；
        long end = System.nanoTime();
        return end - start;//可以得到所有线程完成任务的时间
    }

    public static void main(String[] args) throws InterruptedException{
        TestHarness test = new TestHarness();

        Thread.sleep(1000);

        long time = test.timeTasks(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("任务开始！");
            }
        });

        Thread.sleep(1000);

        System.out.println("花费的时间为："+time);
    }
}
