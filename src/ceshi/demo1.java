package ceshi;

import java.util.Scanner;
/**
 * @Author: xk
 * @Date: 2018/9/28
 * @Version 1.0
 */
public class demo1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {//注意while处理多个case
                int n = in.nextInt();
                int k = in.nextInt();
                System.out.println(n);
            }
        }
}
