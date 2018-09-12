package duoxiancheng;

import java.util.Vector;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 * 向Vector中添加一个新方法：如果元素不存在，则添加；
 * putIfAbsent方法
 */
public class BetterVector<E> extends Vector<E>{
    // When extending a serializable class, you should redefine serialVersionUID
    static final long serialVersionUID = -3963416950630760754L;

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent)
            add(x);
        return absent;
    }
}
