class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = (left +right)/2;

            int val = nums[mid];
            if(val < nums[right] ){
                right = mid;
            }else if ( val > nums[left]){
                left = mid;
            }else{
                return nums[mid];
            }
        }

        return nums[left];
    }
}