package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class Counter {
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
