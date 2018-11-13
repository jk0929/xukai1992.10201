package ceshi;

/**
 * @Author: xk
 * @Date: 2018/10/24
 * @Version 1.0
 */
public class demo8 {
    public static void main(String[] args){
        int[] array = new int[]{1,2,5,3};
        quickSort(array, 0, array.length-1);
        for (int num:array){
            System.out.print(num+" ");
        }
    }

    public static int sortFirst(int[] array, int lo, int hi){
        int key = array[lo];//比较的值x
        while (lo < hi){
            while (array[hi]>=key && lo<hi){//hi向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo]<=key && lo<hi){//lo向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void quickSort(int[] array, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int index = sortFirst(array, lo, hi);
        quickSort(array, lo, index-1);
        quickSort(array, index+1, hi);
    }
}
