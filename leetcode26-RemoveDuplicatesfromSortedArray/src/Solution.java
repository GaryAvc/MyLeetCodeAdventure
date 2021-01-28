class Solution {


    public int removeDuplicates(int[] nums) {

        if(nums.length==0){
            return 0 ;
        }

        int count = 1;
        int left = 0;

        for(int right =1;right<nums.length;right++){

            if(nums[left]!=nums[right]){
                count++;
                left++;
                nums[left]=nums[right];
            }

        }

        return count   ;
    }
}