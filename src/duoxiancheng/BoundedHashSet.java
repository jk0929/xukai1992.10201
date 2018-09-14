package duoxiancheng;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        //将set集合变成同步的set集合
        sem = new Semaphore(bound);//初始化数量：同时访问一个特定资源，最大的操作数量；
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();//当添加一个对象时候，需要向Semaphore获取一个许可；
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);//向set集合中添加一个对象；
            return wasAdded;
        } finally {
            if (!wasAdded)//如果添加一个为null的对象，则立即释放许可；
                sem.release();
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)//如果删除一个对象成功后，必须立即释放许可
            sem.release();
        return wasRemoved;
    }
}
