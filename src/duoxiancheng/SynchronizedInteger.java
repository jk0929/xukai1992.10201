package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 * 线程安全的可变值
 */
public class SynchronizedInteger {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
