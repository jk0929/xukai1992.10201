package suanFaDemo;

/**
 * Created by Admin on 2018/6/29.
 实现 strStr() 函数。
 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 如果不存在，则返回 -1。

 示例 1:
 输入: haystack = "hello", needle = "ll"
 输出: 2

 示例 2:
 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:
 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 对于本题而言，当 needle 是空字符串时我们应当返回 0。
 */
public class demo09 {
    public static void main(String[] args){
        String haystack = "aaaaa";
        String needle = "bba";
        Solution9 solution9 = new Solution9();
        int index = solution9.strStr(haystack,needle);
        System.out.println(index);
    }
}
class Solution9 {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(null)){
            return -1;
        }
        if(!haystack.equals(null) && needle.equals(null)){
            return 0;
        }
        int index = haystack.indexOf(needle);
        return index;
    }
}

