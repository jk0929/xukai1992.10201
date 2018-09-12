package duoxiancheng;

import java.util.Vector;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 * UnsafeVectorHelpers
 * 在交替执行getLast，getLast方法出现线程安全问题：
 *    如：一个线程删除了9下标的元素，另外一个线程已经知道list有10个元素，
 *    但是最后一个元素已经被删除了，就会抛出数组下标越界的异常；
 */
public class UnsafeVectorHelpers {

    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
