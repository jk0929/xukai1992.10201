package duoxiancheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 * 非线程安全的，不要这么做；
 */
public class BadListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {//加锁对象不是list，不能保证同步
        boolean absent = !list.contains(x);
        //因为list.contains（）方法加锁不是在BadListHelper对象上面；
        if (absent)
            list.add(x);
        return absent;
    }
}

class GoodListHelper <E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {//客户端加锁
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}