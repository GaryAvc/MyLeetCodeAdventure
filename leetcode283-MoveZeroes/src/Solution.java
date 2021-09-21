class Solution {
    public void moveZeroes(int[] nums) {

        int count = 0;

            for (int i = 0; i < nums.length; ++i) {


                if( i == nums.length - count){
                    break;
                }
                if (nums[i] == 0) {
                    nums = move(nums, i);
                    i--;
                    count++;
                }
            }


    }

    public int[] move( int[]nums, int start){

        for(int i = start;i< nums.length-1;i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = 0;
        return nums;
    }
}