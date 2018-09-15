package paixu;

/**
 * @Author: xk
 * @Date: 2018/9/14
 * @Version 1.0
 * 冒泡排序：
 * 例子： 9    7    5    3     1
 *       7    9    5    3     1:如果9>7,则交换，就是比较前后两个数据的大小，将大向后交换；
 *       ....
 *       7    5    3    1     9:经过一个循环之后，最大的数到了最后；
 *       .....
 *       5    3    1    7     9
 *       3    1    5    7     9
 *       1    3    5    7     9:最后结束条件为：外层循环为：数组的元素个数；
 *
 */
public class BubbleSort {

    public static int[] sortFirst(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int n = nums.length;
        for (int i=0;i<n;i++){
            for (int j=1;j<n-i;j++){
                //交换的时候，需要将最前已经排到最后的数，减去，这样减少了交换次数
                if(nums[j-1] > nums[j]){
                    int temp;
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /*
     *下面对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。
     * 明显如果有一趟没有发生交换，说明排序已经完成。
     */
    public static int[] sortTwo(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int n = nums.length;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i=1;i<n;i++){
                if(nums[i-1] > nums[i]){
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                    flag = true;
                }
            }
            n--;
        }
       return nums;
    }

    /**
     * 优化：如果有100个数的数组，仅前面10个无序，后面90个都已排 好序且都大于前面10个数字，
     * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
     * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     * @param nums
     * @return
     */
    public static int[] sortThree(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int k;
        int flag;
        int n = nums.length;
        flag = n;
        while (flag > 0){
            k = flag;
            flag = 0;
            for (int i=1;i<k;i++){
                if(nums[i-1] > nums[i]){
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                    flag = i;
                }
            }
            k--;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,7};
//        nums = sortFirst(nums);
//        nums = sortTwo(nums);
        nums = sortThree(nums);
        for (int num : nums){
            System.out.println(num +" ");
        }
    }
}
