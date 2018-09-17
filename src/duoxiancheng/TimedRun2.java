package duoxiancheng;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static duoxiancheng.LaunderThrowable.launderThrowable;
import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 */
public class TimedRun2 {
    private static final ScheduledExecutorService cancelExec = newScheduledThreadPool(1);

    public static void timedRun(final Runnable r, long timeout, TimeUnit unit)
            throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null)
                    throw launderThrowable(t);
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);

        //运行timeRun方法的线程，将等t毫秒时间
        taskThread.join(unit.toMillis(timeout));

        task.rethrow();
    }
}
