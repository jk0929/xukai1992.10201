package suanFaDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 2018/6/26.
 *
 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class demo04 {
    public static void main(String[] args){
        Solution4 solution4 = new Solution4();
        List<String > list = solution4.generateParenthesisTwo(3);
        for (String str:list){
            System.out.println(str);
        }
    }
}
class Solution4 {
    //采用递归，并记录左、右括号的个数
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }
   public void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right)
            return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
    }

    public List<String> generateParenthesisTwo(int n) {
        Set<String> res = new HashSet<>();
        if (n == 0) {
            res.add("");
        } else {
            List<String> pre = generateParenthesisTwo(n - 1);
            for (String str : pre) {
                for (int i = 0; i < str.length(); ++i) {
                    if (str.charAt(i) == '(') {
                        str = str.substring(0, i + 1) + "()" + str.substring(i + 1, str.length());
                        res.add(str);
                        str = str.substring(0, i + 1) +  str.substring(i + 3, str.length());
                    }
                }
                res.add("()" + str);
            }
        }
        return new ArrayList(res);
    }
}

