package paixu;

/**
 * @Author: xk
 * @Date: 2018/9/14
 * @Version 1.0
 * 希尔排序的实质就是分组插入排序
 */
public class ShellSort {

    public static void shellSort(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;
        int i,j,gap;
        for (gap=n/2;gap>0;gap=gap/2){//计算gap
            for (i=0;i<gap;i++){//按组
                for (j=i+gap;j<n;j+=gap){//每个组内，进行插入排序
                    if(nums[j]<nums[j-gap]){
                        int temp = nums[j];
                        int k = j-gap;
                        while (k>=0&&nums[k]>temp){
                            nums[k+gap] = nums[k];
                            k = k-gap;
                        }
                        nums[k+gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort1(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int j;
        int gap;
        int n = nums.length;
        for (gap = n/2;gap>0;gap=gap/2){//步长
            for (j=gap;j<n;j++){//从下标gap开始，向后循环
                if(nums[j] < nums[j-gap]){
                    int temp = nums[j];
                    int k = j-gap;
                    while (k>=0&&nums[k]>temp){
                        nums[k+gap] = nums[k];
                        k = k-gap;
                    }
                    nums[k+gap] = temp;
                }
            }
        }
    }

    public static void shellSort2(int[] nums){
        if(nums == null || nums.length == 0){
           return;
        }
        int i,j;
        int n = nums.length;
        int gap;
        for (gap=n/2;gap>0;gap=gap/2){
            for (i=gap;i<n;i++){
                for (j=i-gap;j>=0&&nums[j]>nums[j+gap];j=j-gap){
                    //交换两个数
                    int temp = nums[j];
                    nums[j] = nums[j+gap];
                    nums[j+gap] = temp;
                }
            }
        }
    }


    public static void main(String[] args){
        int[] nums = new int[]{38,65,97,26,13,27,49,55,4};
//        shellSort(nums);
//        shellSort1(nums);
        shellSort2(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }
}
