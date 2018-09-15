package paixu;

/**
 * @Author: xk
 * @Date: 2018/9/14
 * @Version 1.0
 * 选择排序：将min先定为0，之后从所有数中选出一个最小值，两个数进行交换；
 */
public class Selectsort {
    public static void selectSort(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;
        int j;
        for (int i=0;i<n;i++){
            int min = i;//最小值的下标
            for (j = i+1;j<n;j++){
                if(nums[j] < nums[min]){
                    min = j;//更新最小值下标
                }
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }


    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,2};
        selectSort(nums);
        for (int num:nums){
            System.out.println(num);
        }

    }
}
