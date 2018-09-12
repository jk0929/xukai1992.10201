package duoxiancheng;

import java.util.Vector;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class SafeVectorHelpers {

    public static Object getLast(Vector list) {
        synchronized (list) {//采用客户端加锁的方式来保证复合操作的线程安全问题
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}
