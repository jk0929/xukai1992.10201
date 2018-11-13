package Demoscnk;

/**
 * @Author: xk
 * @Date: 2018/9/19
 * @Version 1.0
 */
public class demo1 {
    public static void main(String[] args){
        long nowTime = System.currentTimeMillis();
        int[] array3 = new int[]{1,2,2,2,1,4,5,1,2,4,2};
        for (int num : array3){
            System.out.println(num);
        }
        System.out.println();
        long time = System.currentTimeMillis();
        System.out.println("耗费时间为:" + (time - nowTime)+ "毫秒");
    }
    public static int getTwo(int[] a,int[] b){
        if(a == null || a.length == 0){
            return 0;
        }
        if(b == null || b.length == 0){
            return 0;
        }
        int n = a.length;
        for (int i=0;i<n;i++){

        }
        return 0;
    }
}
