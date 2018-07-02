package suanFaDemo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 2018/4/7.
 * 分离链接法类：来解决当一个元素被插入到一个已经插入的元素散列到相同的值；
 */
public class SeparateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<T>[] theLists;
    private int currentSize;
    public SeparateChainingHashTable(int currentSize){
        theLists = new List[nextPrime(currentSize)];
        for (int i=0;i<currentSize;i++){
            theLists[i] = new LinkedList<>();
        }
    }
    public SeparateChainingHashTable(){
        this(SeparateChainingHashTable.DEFAULT_TABLE_SIZE);
    }

    /**
     * 找到下一个素数；
     * @param n
     * @return
     */
    private static int nextPrime(int n){
        if (n%2==0)
            n++;
        while (!isPrime(n)){
            n +=2;
        }
        return n;
    }

    /**
     * 判断是否为一个素数；
     * @param n
     * @return
     */
    private static boolean isPrime(int n){
        if (n == 2||n == 3){
           return false;
        }
        if(n == 1||n%2 == 0){
            return false;
        }
        for (int i=3;i*i<=n;i+=2){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    public void makeEmpty(){
        for (int i=0;i<theLists.length;i++)
            theLists[i].clear();
        currentSize = 0;
    }

    /**
     * 散列表的hash函数；
     * @param x
     * @return
     */
    private int myhash(T x){
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal<0)
            hashVal += theLists.length;
        return hashVal;
    }

    /**
     * 判断x值是否在散列表中；
     * @param x
     * @return
     */
    public boolean contains(T x){
        int xHash  = myhash(x);
        List<T> whichList = theLists[xHash];
        return whichList.contains(x);
    }
    public void remove(T x){
        List<T> whichList = theLists[x.hashCode()];
        if(whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }
    /**
     * 插入x值
     * @param x
     */
    public void insert(T x){
        int xHash = myhash(x);
        List<T> whichList = theLists[xHash];
        if (!whichList.contains(x)) {
            whichList.add(x);
            currentSize++;
            if (currentSize > theLists.length) {
                rehash();
            }
        }
    }

    /**
     * 当执行insert操作时候，如果list数组太小，数组需要增加为原来数组的两倍；
     */
    private  void rehash(){
        List<T>[] oldLists = theLists;
        theLists = new List[nextPrime(2*theLists.length)];
        for (int i=0;i<theLists.length;i++){
            theLists[i] = new LinkedList<T>();
        }
        for (List<T> list:oldLists){
            for (T x:list)
                insert(x);
        }
    }



}
