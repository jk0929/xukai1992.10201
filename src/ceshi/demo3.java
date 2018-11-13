package ceshi;

/**
 * @Author: xk
 * @Date: 2018/9/29
 * @Version 1.0
 */
import java.util.Scanner;
public class demo3 {
    static int num2 = 0;
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {//注意while处理多个case
                int n = in.nextInt();
                 fun(n);
                System.out.println(num2);
            }
        }

        public static void fun(int n){
            if (n == 1){
              return;
            }
            if (n == 2){
                num2++;
                return;
            }
            else if (n >= 3){
                num2 = num2+n/3;
                fun(n/3+n%3);
            }
        }

}
