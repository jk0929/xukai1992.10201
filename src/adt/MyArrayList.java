package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Admin on 2018/4/1.
 * 实现ArrayList类；
 * */
public class MyArrayList<T> implements Iterable<T>{
    private static final int DEFAULT_CAPACITY = 10;//数组默认的大小
    private int theSize;//数组的大小
    private T[] theItems;//数组的数据

    public MyArrayList(){
        doClear();
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int x){
        if(x<0 || x>=size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[x];
    }

    public T set(int x,T newVal){
        if(x<0 || x>=size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[x];
        theItems[x] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity){//使数组的容量与数组的数据保持一致的大小
        if(size() > newCapacity){
            return;
        }
        T[] old = theItems;
        theItems = (T[])new Object[newCapacity];
        for(int i=0;i<size();i++){
            theItems[i] = old[i];
        }
    }

    private void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void clear(){
        doClear();
    }

    public void trimToSize(){
        ensureCapacity(size());
    }

    public void add(int x,T t){
        if (theItems.length == size()){
            ensureCapacity(2*size()+1);
        }
        for(int i=theSize;i>x;i--){//将x序号之后的数组元素，都向后移动一位
            theItems[i] = theItems[i-1];
        }
        theItems[x] = t;

        theSize++;
    }

    public boolean add(T t){
        add(size(),t);
        return true;
    }

    public T remove(int x){
         T removedItem = theItems[x];
         for(int i=x;i<size()-1;i++){
             theItems[i] = theItems[i+1];
         }
         theSize--;
        return removedItem;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{//内部类
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
