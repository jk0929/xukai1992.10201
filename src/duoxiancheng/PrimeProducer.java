package duoxiancheng;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 */
public class PrimeProducer extends Thread{

    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            //在循环中，不断的判断当前线程的中断状态
            //采用循环，因为put方法一直处于阻塞的状态
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
            /* 允许线程退出 */
        }
    }

    public void cancel() {
        interrupt();
    }
}
