package suanFaDemo;

import java.util.*;

/**
 * Created by Admin on 2018/6/29.
 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

 示例 1:
 输入:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出: [0,9]
 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。

 示例 2:
 输入:
 s = "wordgoodstudentgoodword",
 words = ["word","student"]
 输出: []
 "wordgoodgoodgoodbestword"
 ["word","good","best","good"]
 */
public class demo11 {
    public static void main(String[] args){
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        Solution11 solution11 = new Solution11();
        List<Integer> list = solution11.findSubstring(s,words);
        for (Integer integer:list){
            System.out.println(integer+" ");
        }
    }
}
class Solution11 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.equals(null) || s.equals("")){
            return list;
        }
        if(words == null || words.length == 0){
            return list;
        }
        int length = words.length*words[0].length();
        List<String> strings = new ArrayList<>();
        listAllTwo(Arrays.asList(words), "",length,strings);
        removeDuplicate(strings);
        for (String str:strings){
            getList(str,s,list);
        }
        return list;
    }
    public void getList(String str,String s,List<Integer> list){
        int index = s.indexOf(str);
        if (index != -1){
            list.add(index);
        }
        while (index != -1){
            index++;
            index = s.indexOf(str,index);
            if (index != -1){
                list.add(index);
            }
        }
    }
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    public void listAllTwo(List<String> candid,String prefix,int length,List<String> strings){
        if(prefix.length() == length) {
            strings.add(prefix);
        }
        for (int i=0;i<candid.size();i++){
            List<String> temp = new LinkedList<>(candid);
            listAllTwo(temp,prefix+temp.remove(i),length,strings);
        }
    }
}
