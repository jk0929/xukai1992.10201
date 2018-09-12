package duoxiancheng;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class TaskRunnable implements Runnable{

    BlockingQueue<Task> queue;

    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            // restore interrupted status
            //恢复被中断的状态
            Thread.currentThread().interrupt();
        }
    }

    private void processTask(Task task) {
        // Handle the task
    }

    interface Task {
    }
}
