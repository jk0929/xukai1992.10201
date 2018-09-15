package duoxiancheng;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xk
 * @Date: 2018/9/15
 * @Version 1.0
 */
public class Memoizer2<A, V> implements Computable<A, V>{

    private final Map<A, V> cache = new ConcurrentHashMap<>();//线程安全的

    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
