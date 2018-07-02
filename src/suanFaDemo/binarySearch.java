package suanFaDemo;

/**
 * Created by Admin on 2018/3/27.
 * 二分法算法基本思路：
 *    1.采用“分治”策略，首先取中间位置的值，比较是否在左半边的序列中，还是右半边的序列中；
 *    2.采用1的策略，直到知道序列的值，或是返回“找不到”
 *    3.采用二分法查找的前提为：已经排序好的序列；
 *    4.简单列子：
 *        low    mid   high
 *         1 3 5 6 7 9 10
 */
public class binarySearch {

    public static void main(String[] args){
        int[] array=new int[]{1,3,5,6,7,9};
        int index = binarySearch(array,3);
        System.out.print(index);
    }

    public final static  int NOT_FOUND = -1;
    private static int binarySearch(int[] array,int x){
        int low = 0;
        int high = array.length-1;
        int mid;
        while (low <= high){
            mid = (low+high)/2;
            if(x>array[mid]){
                low = mid+1;
            }
            if(x<array[mid]){
                high = mid-1;
            }
            if(x == array[mid]){
                return mid;
            }
        }
        return NOT_FOUND;
    }
}
