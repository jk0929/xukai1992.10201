package paixu;

/**
 * @Author: xk
 * @Date: 2018/9/14
 * @Version 1.0
 */
public class MergeSort {
    /**
     * 将2个有序数组，合并为一个新的数组
     * @param a
     * @param b
     * @param c
     */
    public static  void memeryArray(int[] a,int[] b,int[] c){
        if(a == null || b == null){
            return;
        }
        int n = a.length;
        int m = b.length;
        int i,j,k;
        i = j = k = 0;
        while (i<n && j<m){
            if(a[i] < b[j]){
                c[k] = a[i];
                k++;
                i++;
            }else {
                c[k] = b[j];
                k++;
                j++;
            }
        }
        while (i<n){
            c[k] = a[i];
            k++;
            i++;
        }
        while (j<n){
            c[k] = b[j];
            k++;
            j++;
        }
    }

    public static void MergeSort(int[] a, int n){
        if(a == null || a.length == 0){
            return;
        }
        n = a.length;
        int[] temp = new int[n];
        mergesort(a, 0, n-1, temp);
    }

    public static void mergesort(int[] a, int first, int last, int[] temp){
        if(first < last){
            int mid = (first+last)/2;
            mergesort(a, first, mid ,temp);//左边有序
            mergesort(a, mid+1, last, temp);//右边有序
            mergeArray(a, first, mid, last, temp);
        }
    }

    public static void mergeArray(int[] a, int first, int mid, int last, int[] temp){
        if(a == null || a.length == 0){
            return;
        }
        int i,j;
        i = first;
        j = mid+1;
        int n = last;//最后的下标
        int m = mid;
        int k = 0;

        while (i<=m&&j<=n){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        while (i<=m){
            temp[k++] = a[i++];
        }

        while (j<=n){
            temp[k++] = a[j++];
        }
        for (i = 0;i<k;i++){
            a[first+i] = temp[i];
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{2,1,3,4,6};
        MergeSort(a, a.length);
        for (int n:a){
            System.out.println(n);
        }
    }
}
