package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 * point是一个不可变的类，所以它是一个线程安全的类
 */
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
