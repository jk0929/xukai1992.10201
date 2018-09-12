package duoxiancheng;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class HiddenIterator {
    private final Set<Integer> set = new HashSet<Integer>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        System.out.println("DEBUG: added ten elements to " + set);
        //隐藏在字符串连接中的迭代操作（不要这样做）
    }
}
