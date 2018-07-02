package suanFaDemo;

/**
 * Created by Admin on 2018/3/26.
 * 插入排序算法基本思路：
 *     1.将第i个位置的元素，与前i个排好序的一组数，分别比较。直到重新排序好；
 *     2.元素通过数组传入参数；
 *     3.例子：
 *   原来：  1 3 5 8 7 9  temp=7
 *   第4趟： 1 3 5 7 8 9（7为第4位置上面的元素插入）
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] array=new int[]{1,3,5,8,7,9};
        insertionSort(array);
        for (int a: array) {
            System.out.print(a+",");
        }
    }

    private static void insertionSort(int[] array){
        for(int i=1;i< array.length;i++){//控制趟数，从位置1开始，到最后
            int temp=array[i];
            int j;
            for( j=i;j>0&&temp<array[j-1];j--){//控制位置j插入到j位置之前合适的位置
                array[j]=array[j-1];
            }
            array[j]=temp;
        }
    }

}
