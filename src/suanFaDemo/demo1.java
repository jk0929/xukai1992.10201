package suanFaDemo;

/**
 * @Author: xk
 * @Date: 2018/9/26
 * @Version 1.0
 */
public class demo1 {
    public static void main(String[] args) {
        Integer integer = MathP(50);
        System.out.println(integer);
    }

    public  static int MathP(int length){
        int[] iArray = new int[length+1];
        iArray[0] = 0;
        iArray[1] = 1;
        for (int i = 2; i <= length; i++){
            iArray[i] = iArray[i - 1] + iArray[i - 2];}
             return iArray[length];
    }

}
