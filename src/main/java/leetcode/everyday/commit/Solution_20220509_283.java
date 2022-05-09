package leetcode.everyday.commit;

/**
 *11
 *
 */


public class Solution_20220509_283 {

    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        //两个指针
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int [] a = new int[]{0,1,0};

    }
}
