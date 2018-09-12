package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 * 非线程安全的可变值
 */
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
