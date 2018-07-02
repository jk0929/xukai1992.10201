package suanFaDemo;

import java.util.Arrays;

/**
 * Created by Admin on 2018/6/29.
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 必须原地修改，只允许使用额外常数空间。
 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 暂时有点问题
 */
public class demo12 {
    public static void main(String[] args){
        Solution12 solution12 = new Solution12();
        int[] nums = new int[]{1,1,5,4,3};
        solution12.nextPermutation(nums);
        for (int num:nums){
            System.out.print(num+" ");
        }
    }
}
class Solution12 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int[] numsTwo = Arrays.copyOf(nums,nums.length);
        Arrays.sort(numsTwo);
        int firstValue = nums[0];
        int twoValue = nums[1];
        int index = 0;
        for (int i=numsTwo.length-1;i>=0;i--){
            if(twoValue == numsTwo[i]){
                index = i;
                break;
            }
        }
        int twoNewValue;
        twoNewValue = numsTwo[index+1];
        if (firstValue != twoNewValue){
            int temp = nums[1];
            nums[1] = nums[index+1];
            nums[index+1] = temp;
        }else {
            Arrays.sort(nums);
        }
    }
}
