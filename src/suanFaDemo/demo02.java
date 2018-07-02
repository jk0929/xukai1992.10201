package suanFaDemo;

import java.util.Stack;

/**
 * Created by Admin on 2018/6/25.
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:
 输入: "()"
 输出: true

 示例 2:
 输入: "()[]{}"
 输出: true

 示例 3:
 输入: "(]"
 输出: false

 示例 4:
 输入: "([)]"
 输出: false

 示例 5:
 输入: "{[]}"
 输出: true
 */
public class demo02 {
    public static void main(String[] args){
        String str = "";
        Solution2 solution = new Solution2();
        Boolean isTrue = solution.isValid(str);
        System.out.println(isTrue);
    }
}
class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s == null){
            return false;
        }
        if(s.length()%2 != 0){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        char c;
        Integer count = 0;//记录在字符串中，括号出现的次数
        Integer charNum;
        for (int i=0;i<s.length();i++){
            c= s.charAt(i);
            charNum = whatParent(c);
            if(charNum < 0){
                count++;
                stack.push(c);
            }else if (charNum > 0){
                count++;
                if (stack.isEmpty()){
                    return false;
                }
                if(charNum+whatParent(stack.peek()) == 0){
                    stack.pop();
                }else {
                    return false;
                }
            }else {

            }
        }
        if(count > 0 && stack.isEmpty()){
            return true;
        }
        return false;
    }

//    public boolean isParenthesesValid(String s) {
//        //字符串为空
//        if (s==null){
//            return false;
//        }
//        Stack<Character> stack=new Stack<>();
//        //存储遍历的字符
//        char ch;
//        //存储字符转换后的数字
//        int parentNum;
//        //记录下括号出现的次数
//        int count=0;
//        for (int i=0;i<s.length();i++){
//            ch=s.charAt(i);
//            parentNum=whatParent(ch);
//            if(parentNum<0){
//                count++;
//                // <0表示这是个左括号
//                stack.push(ch);
//            }else if(parentNum>0){
//                count++;
//                // >0表示这是个右括号
//                if (stack.isEmpty()){
//                    //右括号左边没有左括号的特殊情况
//                    return false;
//                }
//                if(parentNum+whatParent(stack.peek())==0){
//                    //栈顶是对应的左括号
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }else{
//                // =0 这不是一个括号，不管
//            }
//        }
//        //字符串中有括号且栈最后被清空了，表示括号成对出现且有效
//        if (count > 0 && stack.isEmpty()){
//            return true;
//        }
//        return false;
//    }

    public int whatParent(char ch) {
        switch (ch) {
            case '(':
                return -1;
            case '[':
                return -2;
            case '{':
                return -3;
            case ')':
                return 1;
            case ']':
                return 2;
            case '}':
                return 3;
        }
        return 0;
    }

}

