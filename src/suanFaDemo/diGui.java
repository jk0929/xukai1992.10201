package suanFaDemo;

/**
 * Created by Admin on 2018/3/27.
 * 递归调用的情况分析：
 *    1.采用递归调用必须有两个前提：
 *         有最终的基准，如：f(0)=1;
 *         所有调用函数都必须朝着基准情况去运行，直到得出基准情况的值，从而求出被计算机挂起的其他函数值；
 *    2.采用递归的情况：一般一个函数的本身包含这个函数的本身；
 *    3.具体案例：
 *        f(x)=2*f(x-1)+x^2
 *        f(0)=1;
 *        f(1)=2*f(0)+1=3;
 */
public class diGui {

    public static void main(String[] args){
       int sum = getDiGui(5);
       System.out.print(sum);
    }

    private static int getDiGui(int x){
        if(0 == x){
            return 1;
        }else {
            return 2*getDiGui(x-1)+(int)Math.pow(x,2);
        }

    }
}
