package duoxiancheng;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 * 当生产者由于生产的效率大于消费者，并且阻塞队列已经满了，所以生产者会一直阻塞在put方法上面，
 * 即使想通过cance方法来取消任务，也不行。因为处于一直阻塞足状态，不能获取cancelled的状态；
 */
public class BrokenPrimeProducer extends Thread{

    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
