package threadDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class demo<T> {

    private final Set<T> set;

    private final Semaphore sem;

    public demo(int num){
        set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(num);
    }

    public boolean add(T t)throws InterruptedException{
        sem.acquire();
        boolean isAdd = false;
        try{
            isAdd = set.add(t);
            return isAdd;
        }finally {
            if(!isAdd){
                sem.release();
            }
        }
    }

    public boolean remove(T t)throws InterruptedException{
        boolean isRemove = set.remove(t);
        if(isRemove){
            sem.release();
        }
        return isRemove;
    }

}
