package duoxiancheng;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 */
public class NoncancelableTask{

    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    // 重新尝试
                }
            }
        } finally {
            if (interrupted)
                Thread.currentThread().interrupt();
        }
    }

    interface Task {
    }
}
