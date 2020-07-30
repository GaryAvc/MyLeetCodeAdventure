class Solution {
    public int findPeakElement(int[] nums) {
        int maxIndex=0;
        for(int i=0;i<nums.length;++i){
            if(nums[maxIndex]<nums[i]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}