//class Solution {
//    public int findPeakElement(int[] nums) {
//        int maxIndex=0;
//        for(int i=0;i<nums.length;++i){
//            if(nums[maxIndex]<nums[i]){
//                maxIndex=i;
//            }
//        }
//        return maxIndex;
//    }
//}

class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while( left + 1 < right){
            int mid = left + (right - left)/2;

            if( nums[mid+1] - nums[mid] > 0 ){
                left = mid;
            }else{
                right = mid;
            }

        }

        if( nums[left] > nums[right]){
            return left;
        }else{
            return right;
        }
    }
}