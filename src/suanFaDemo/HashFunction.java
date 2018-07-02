package suanFaDemo;

/**
 * Created by Admin on 2018/4/7.
 * hash函数：散列函数的三种分析；
 */
public class HashFunction {
    /**
     * 散列函数，实现简单，计算方便快速；但是如果表很长，不能很好的均匀分配关键字；
     * @param key
     * @param tableSize
     * @return
     */
    public static int hashFirst(String key,int tableSize){
        int hashVal = 0;
        for (int i=0;i<key.length();i++){
            hashVal += key.charAt(i);
        }
        return hashVal%tableSize;
    }

    /**
     * 当字符串至少有三个字母的时候，有26*26*26=17576种组合，但是实际三个字母组合为单词的可能组合为：2851种；
     * 所以这种情况下，表只有28%被真正散列，被实现。不具有合理的表的大小；
     * @param key
     * @param tableSize
     * @return
     */
    public static int hashTwo(String key,int tableSize){
        int sum = key.charAt(0)+27*key.charAt(1)+27*27*key.charAt(2);
        return sum%tableSize;
    }

    /**
     * 涉及所有关键字的字符串，一般可以较好的分布；
     * @param key
     * @param tableSize
     * @return
     */
    public static int hashThree(String key,int tableSize){
        int hashVal = 0;
        for (int i=0;i<key.length();i++){
            hashVal = 37*hashVal+key.charAt(i);
        }
        hashVal %= tableSize;
        if(hashVal<0){
            hashVal += tableSize;
        }
        return hashVal;
    }

}
