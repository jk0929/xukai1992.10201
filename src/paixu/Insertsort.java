package paixu;

/**
 * @Author: xk
 * @Date: 2018/9/14
 * @Version 1.0
 */
public class Insertsort {

    public static void InsertSortFirst(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;
        for (int i=1;i<n;i++){
            //首先找出小的数；
            int j,k;
            for (j=i-1;j>=0;j--){
                if(nums[j] < nums[i]){//如果已经按从小到大排，则跳出这个循环；
                    break;
                }
            }

            if(j != i-1){//如果相等，则说明排序正确；
                int temp = nums[i];
                for (k=i-1; k>j ; k--)
                    nums[k + 1] = nums[k];
                nums[k + 1] = temp;
            }
        }
    }

    /**
     * 将整个数组分成有序数组，和无序数组；
     *   有序数组从下标0开始，不断循环；
     *   找到需要插入有序的下标，并将这个插入到合适的位置；
     * @param nums
     */
    public static void InsertSot2(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int i,j;
        int n = nums.length;
        for (i = 1; i<n;i++){
            if(nums[i-1] > nums[i]){
                int temp = nums[i];
                for (j=i-1;j>=0&&nums[j]>temp;j--){
                    nums[j+1] = nums[j];
                }
                nums[j+1] = temp;
            }
        }
    }

    public static void InsertSort3(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int i,j;
        int n = nums.length;
        for (i=1;i<n;i++){
            for (j=i-1;j>=0&&nums[j]>nums[j+1];j--){
                //采用交换，将数交换到合适到位置；
                int temp = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = temp;
            }
        }
    }


    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,7};
//        InsertSortFirst(nums);
//        InsertSot2(nums);
        InsertSort3(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }

}
