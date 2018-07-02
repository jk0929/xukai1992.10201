package suanFaDemo;

import java.util.*;

/**
 * Created by Admin on 2018/4/6.
 * 演示TreeMap，它是map的实现类；
 */
public class WordLadder {
    private static boolean oneCharOff(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        int diffs = 0;//计算不同字母数量；
        for (int i = 0; i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                diffs++;
                if(diffs>1){
                    return false;
                }
            }
        }
        return diffs == 1;
    }

    /**
     * 打印出list集合中单词个数大于minWords的所有单词，单词长度；
     * @param adjWords
     * @param minWords
     */
    public static void printHighChangeables(Map<String ,List<String >> adjWords,int minWords){
        for (Map.Entry<String ,List<String >> entry : adjWords.entrySet()){
            List<String > words = entry.getValue();
            if(words.size() >= minWords){
                System.out.print(entry.getKey()+"(");
                System.out.print(words.size()+")");
                for (String  word:words){
                    System.out.print(" "+word);
                }
                System.out.println();
            }
        }
    }

    /**
     * 对键值为key的list中添加value的值；
     * @param map
     * @param key
     * @param value
     * @param <T>
     */
    private static <T> void update(Map<T,List<String >> map,T key,String value){
        List<String > stringList = map.get(key);
        if(stringList == null){
            stringList = new ArrayList<>();
            map.put(key,stringList);
            stringList.add(value);
        }else {
            stringList.add(value);
        }
    }

    /**
     * 计算相邻单词的算法:时间效率最慢；
     * @return
     */
    public static Map<String ,List<String >> computeAdjacentWordsSlow(List<String > strings){
        Map<String ,List<String>> adjWords = new TreeMap<>();
        String[] words = new String[strings.size()];
        strings.toArray(words);//将list转换为string数组;但是存在不同长度的单词，进行比较相邻单词的问题；
        for (int i=0;i<words.length;i++){
            for (int j=i+1;j<words.length;j++){
                if(oneCharOff(words[i],words[j])){
                    update(adjWords,words[i],words[j]);
                    update(adjWords,words[j],words[i]);
                }
            }
        }
        return adjWords;
    }

    /**
     * 按单词长度对所有单词，进行分组；同一个长度的单词，组装在同一个list中；
     * @param strings
     * @return
     */
    public static Map<String ,List<String >> computeAdjacentWordsMedium(List<String > strings){
        Map<String ,List<String >> adjWords = new HashMap<>();
        Map<Integer,List<String >> lengthWords = new HashMap<>();
        for (String word:strings){
            update(lengthWords,word.length(),word);
        }
        for(List<String > valueList : lengthWords.values()){
            String [] stringArray = new String [valueList.size()];
            valueList.toArray(stringArray);//将map中每个lsit集合，循环转化为数组,并使用双层循环；
            for (int i=0;i<stringArray.length;i++){
                for (int j=i+1;j<stringArray.length;j++){
                    if(oneCharOff(stringArray[i],stringArray[i+1])){
                        update(adjWords,stringArray[i],stringArray[j]);
                        update(adjWords,stringArray[j],stringArray[i]);
                    }
                }
            }
        }
        return adjWords;
    }
    public static Map<String ,List<String >> computeAdjacentWords(List<String > strings){
        Map<String ,List<String >> adjWords = new TreeMap<>();
        Map<Integer,List<String >> lengthWords = new TreeMap<>();
        for (String str:strings){
            update(lengthWords,str.length(),str);
        }
        //map.entrySet()方法返回Set<Map.Entry<Integer ,List<String >>>,for循环可以遍历他们；
        for (Map.Entry<Integer ,List<String >> entry:lengthWords.entrySet()){//key与value一一对应，循环每一个;
            List<String > groupsWord = entry.getValue();//得到value中list集合
            int groupNum = entry.getKey();//得到key中单词的长度
            for (int i=0;i<groupNum;i++){
                Map<String ,List<String>> repToWord = new TreeMap<>();
                for (String str:groupsWord){
                    String rep = str.substring(0,i)+str.substring(i+1);
                    update(repToWord,rep,str);
                }
                for (List<String > wordClique:repToWord.values()){
                    if(wordClique.size()>=2){
                        for (String s1:wordClique){
                            for (String s2:wordClique){
                                if(s1!=s2)
                                    update(adjWords,s1,s2);
                            }
                        }
                    }
                }
            }
        }
        return adjWords;
    }
}
