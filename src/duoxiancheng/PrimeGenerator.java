package duoxiancheng;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 */
public class PrimeGenerator implements Runnable{

    private static ExecutorService exec = Executors.newCachedThreadPool();

    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    //使用volatile类型的域来保存取消状态
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    /**
     * 运行一秒钟的素数生成器
     * @return
     * @throws InterruptedException
     */
    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        exec.execute(generator);
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}
