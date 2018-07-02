package suanFaDemo;

import java.math.BigInteger;

/**
 * Created by Admin on 2018/6/29.
 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 返回被除数 dividend 除以除数 divisor 得到的商。

 示例 1:
 输入: dividend = 10, divisor = 3
 输出: 3

 示例 2:
 输入: dividend = 7, divisor = -3
 输出: -2

 说明:
 被除数和除数均为 32 位有符号整数。除数不为 0。
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2  31,  2  31 −1]。本题中，如果除法结果溢出，则返回 2 31 −1。
 */
public class demo010 {
    public static void main(String[] args){
        Integer dividend = -2147483648;
        Integer divisor = -1;
        Solution10 solution10 = new Solution10();
        int value = solution10.divide(dividend,divisor);
        System.out.println(value);
    }
}
class Solution10 {
    public int divide(int dividend, int divisor) {
        String diviStr = dividend+"";
        String divisorStr = divisor+"";
        BigInteger divi = new BigInteger(diviStr);
        BigInteger divisorBig = new BigInteger(divisorStr);
        BigInteger value = divi.divide(divisorBig);
        BigInteger max = new BigInteger(""+Integer.MAX_VALUE);
        BigInteger min = new BigInteger(""+Integer.MIN_VALUE);
        Integer valueTrue;
        if(value.compareTo(max)>0 || value.compareTo(min)<0){
            valueTrue = Integer.MAX_VALUE;
            return valueTrue;
        }
        return value.intValue();
    }
}
