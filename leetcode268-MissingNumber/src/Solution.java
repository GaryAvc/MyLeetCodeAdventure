class Solution {
    public int missingNumber(int[] nums) {

        int len = nums.length;
        for( int i = 0;i<nums.length;i++){
            len ^= i;
            len ^= nums[i];
        }
        return len;
    }
}