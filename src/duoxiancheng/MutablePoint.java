package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 * 不是线程安全的类
 */
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
