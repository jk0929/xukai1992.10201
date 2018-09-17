package duoxiancheng;

import java.util.concurrent.*;

import static duoxiancheng.LaunderThrowable.launderThrowable;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 */
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r, long timeout, TimeUnit unit)
            throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // 接下来任务将会被取消
        } catch (ExecutionException e) {
            // 如果在任务汇总抛出异常，那么重新抛出该异常
            throw launderThrowable(e.getCause());
        } finally {
            // 如果任务已经结束，那么执行取消操作也不会带来任何影响
            task.cancel(true); // 如果任务正在运行，那么将被中断
        }
    }
}
