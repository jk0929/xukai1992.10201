package suanFaDemo;

/**
 * Created by Admin on 2018/3/27.
 * 希尔排序算法基本思路：
 *    1.该算法采用相隔间隔为hk，比较大小并交换位置，又称之为增量排序；
 *    2.一趟排序：间隔位置一样；但是下一趟排序：间隔位置与前一趟的间隔不同；但是最后一次的间隔必须是1；
 *    3.简单例子：（注：shell建议的间隔为：N/2开始）
 *                   0     1    2    3     4     5     6    7    8
 *                   81   11   96    12   35    17    18    94   13  gap=9/2=4  i=gap,i++  j=i,j++
 *            一趟： 35                    81
 *                        11                    17
 *                             18                      96
 *                                   12                      94
 */
public class shellSort {
    public static void main(String[] args){
        int[] array = new int[]{81,11,96,12,35,17,18,94,13};
        getShellSort(array);
        for(int a:array){
            System.out.print(a+",");
        }

    }

    private static void getShellSort(int[] array){
        int gap,i,j;
        for(gap=array.length/2;gap>0;gap/=2){//控制gap的循环
            for(i=gap;i< array.length;i++){//控制i=mid到最大
                int temp = array[i];
                for(j=i;j>=gap&&temp<array[j-gap];j-=gap){//将右半边的数，分别间隔的交换到左半边的序列中；
                    array[j] = array[j-gap];
                }
                array[j] = temp;
            }

        }

    }
}
