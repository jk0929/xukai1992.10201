package ceshi;


/**
 * @Author: xk
 * @Date: 2018/10/15
 * @Version 1.0
 * 快速排序实现
 */
public class demo7 {
    public static void main(String[] args){
        int[] array = new int[]{2,1,4,6,3};
        sort(array, 0, array.length-1);
        for (int num:array){
            System.out.print(num+" ");
        }
    }
    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return;
        }
        int index=partition(array,lo,hi);
        sort(array, lo,index-1);
        sort(array,index+1, hi);
    }
}
