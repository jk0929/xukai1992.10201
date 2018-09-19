package Demoscnk;

/**
 * @Author: xk
 * @Date: 2018/9/17
 * @Version 1.0
 */
public class demo2 {
    public static void main(String[] args) {
        int i = 1,j = 2;
        int k = i+++j++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(k<<j);
        System.out.println(k<<j>>i);


    }
}
