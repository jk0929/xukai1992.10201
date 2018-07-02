package suanFaDemo;

/**
 * Created by Admin on 2018/3/27.
 * 欧几里算法基本思路：
 *    1.gcd(a,b)求值为求整数a,b之间的最大公因数；
 *    2.简单例子：
 *       gcd(50,15)=gcd(15,5)=gcd(5,0)=5
 *           m  n       m=n,n=rem  n=0,m=5
 *        rem=50%15=5   15%5=0
 */
public class gcd {
    public static void main(String[] args){
        int rem = getGcd(50,15);
        System.out.print(rem);
    }
    private static int getGcd(int m,int n){
        int rem;
        while (n!=0){
            rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
}
