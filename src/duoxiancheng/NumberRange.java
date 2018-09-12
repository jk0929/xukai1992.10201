package duoxiancheng;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class NumberRange {
    // 不可变条件为: lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // Warning -- unsafe check-then-act
        if (i > upper.get())//先检查后更新，会出现线程安全问题
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        lower.set(i);
    }

    public void setUpper(int i) {
        // Warning -- unsafe check-then-act
        if (i < lower.get())//先检查后更新，会出现线程安全问题
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
