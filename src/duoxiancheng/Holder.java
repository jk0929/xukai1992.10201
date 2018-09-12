package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
