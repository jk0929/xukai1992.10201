package adt;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Admin on 2018/4/2.
 * 实现双链表的数据类型；
 */
public class MyLinkedList<T> implements Iterable {
    private int theSize;
    private int modCount = 0;
    private NodeLinked<T> beginMarker;//头结点
    private NodeLinked<T> endMarker;//尾节点

    public MyLinkedList() {
        doClear();
    }

    private void doClear() {
        this.beginMarker = new NodeLinked(null, null, null);
        this.endMarker = new NodeLinked(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public void clear() {
        doClear();
    }

    private static class NodeLinked<T> {//嵌套类
        public T data;//数据元素
        public NodeLinked<T> prev;//头结点
        public NodeLinked<T> next;//尾节点

        public NodeLinked(T d, NodeLinked<T> p, NodeLinked<T> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void addBefore(NodeLinked<T> p, T t) {//在p之前插入节点x
        NodeLinked<T> newNode = new NodeLinked<T>(t, p.prev, p);//这个构造器已经将x的prev,next指定好了
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    public void add(int x,T t){//向x序号之前插入节点t
        NodeLinked<T> p = getNode(x);
        addBefore(p,t);
    }

    public boolean add(T t){//向尾部插入一个节点t
        add(size(),t);
        return true;
    }

    private T remove(NodeLinked<T> p) {//注意p指向的是当前要删除的节点,而且只需要移除被引用的指针就可以了
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount--;
        return p.data;
    }

    private NodeLinked<T> getNode(int x, int lower, int upper) {
        NodeLinked<T> p;
        if (x < lower || x > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (x < size() / 2) {
            p = beginMarker.next;
            for (int i = 1; i < x; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size() - 1; i > x; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    private NodeLinked<T> getNode(int x){
        return getNode(x,0,size()-1);
    }

    public T remove(int x){
        NodeLinked<T> p = getNode(x);
        remove(p);
        return p.data;
    }

    public T set(int x,T newVal){
        NodeLinked<T> p = getNode(x);
        T oldData = p.data;
        p.data = newVal;
        return oldData;
    }


    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{

        private NodeLinked<T> current = beginMarker.next;

        private int expectedModCount = modCount;

        private boolean okToRemove = true;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {//返回现在的元素，并引用下一个元素
            if(modCount != expectedModCount){
               throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;

        }
    }
}
