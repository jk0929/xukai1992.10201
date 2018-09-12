package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 */
public class PrivateLock {
    private final Object myLock = new Object();
   //Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}
