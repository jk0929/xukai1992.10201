package paixu;

/**
 * @Author: xk
 * @Date: 2018/9/15
 * @Version 1.0
 * 快速排序
 */
public class QuickSort {

    public static int adjustAarray(int[] a, int l, int r){//返回调整后基准数的位置
        if(a == null || a.length == 0){
            return 0;
        }
        int i = l;//s[l]即s[i]就是第一个坑
        int j = r;
        int x = a[l];
        while (i < j){
            // 从右向左找小于x的数来填s[i]
            while (i<j&&a[j]>=x){
                j--;
            }
            if(i<j){
                a[i] = a[j];
                i++;
            }

            // 从左向右找大于或等于x的数来填s[j]
            while (i<j&&a[i]<x){
                i++;
            }
            if(i<j){
                a[j] = a[i];
                j--;
            }
        }
        a[i] = x;
        return i;
    }

    public static void quickSort(int[] a, int l, int r){
        if(l < r){
           int i = adjustAarray(a, l, r);//先成挖坑填数法调整s[]
           quickSort(a, l, i-1);// 递归调用
           quickSort(a, i+1, r);
        }
    }

    public static void quickSort2(int[] a, int l, int r){
        if(a == null || a.length == 0){
            return;
        }
        if(l < r){
            int i = l;
            int x = a[l];
            int j = r;
            while (i<j){
                while (i<j&&a[j]>x){
                    j--;
                }
                if(i<j){
                    a[i++] = a[j];
                }
                while (i<j&&a[i]<=x){
                    i++;
                }
                if(i<j){
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            quickSort2(a, l, i-1);
            quickSort2(a, i+1, r);
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{1,3,2,4,6,5};
//        quickSort(a, 0, a.length-1);
        quickSort2(a, 0, a.length-1);
        for (int num:a){
            System.out.println(num);
        }
    }
}
