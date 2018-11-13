package suanFaDemo;

import java.util.Iterator;

/**
 * @Author: xk
 * @Date: 2018/9/22
 * @Version 1.0
 */
public class MyArrayList<T> implements Iterable<T> {

    private T[] iteams;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        doClear();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int k){
        if (k<0 || k>=size()){
            throw new ArrayIndexOutOfBoundsException( "Index " + k + "; size " + size( ) );
        }
        return iteams[k-1];
    }

    public T set(int k, T value){
        if (k<0 || k>=size()){
            throw new ArrayIndexOutOfBoundsException( "Index " + k + "; size " + size( ) );
        }
        T oldValue = iteams[k-1];
        iteams[k-1] = value;
        return oldValue;
    }

    private void doClear() {

    }

    public void ensureCapacity(int capacity){
        if (capacity < size)
            return;
        T[] iteamsOld = iteams;
        iteams = (T[])new Object[capacity];
        for (int i=0;i<iteamsOld.length;i++){
            iteams[i] = iteamsOld[i];
        }
    }

    public boolean add(T t){
        add(size(), t);
        return true;
    }

    private void add(int idx, T t) {
        if (size() == iteams.length){
            ensureCapacity(2*size()+1);
        }
        for (int i=size;i>idx;i--){
            iteams[i] = iteams[i-1];
        }
        iteams[idx] = t;
        size++;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
