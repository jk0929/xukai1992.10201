package ceshi;

/**
 * @Author: xk
 * @Date: 2018/10/15
 * @Version 1.0
 */
public class demo4 {
    public static void main(String[] args) {
//        float x = 10/4;
//        System.out.println(x);
        int x=0,y=3;
        if(x<y || y--==x){
            ++x;
        }
        System.out.print("x="+x++);
        System.out.println(",y="+y);
        System.out.println(y++);
    }
}
