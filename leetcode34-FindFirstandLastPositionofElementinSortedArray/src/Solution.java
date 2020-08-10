class Solution {

    public static void main(String[] args) {
        int [] x = {5,7,7,8,8,10};
        Solution s = new Solution();
        System.out.println( s.searchRange( x, 8));
    }

    int [] answer ;

    public int[] searchRange(int[] nums, int target) {
        answer = new int[2];
        int [] noTarget = {-1,-1};

        if( nums.length==0){
            return noTarget;
        }

        if( nums.length ==1 && nums[0] != target){
            return noTarget;
        }else if(nums.length ==1 && nums[0] == target){
            int [] size1 = {0,0};
            return size1;
        }

        int targetIndex = bs( nums,target);
        return targetIndex == -1 ? noTarget : expand( nums,target,targetIndex);
    }

    /*
    this function apply binary search (lgn)
     */
    private int bs (int[] nums,int target ){
        int lo = 0;
        int hi = nums.length-1;
        int mid;

        while(lo<=hi){
            mid = lo + (hi-lo)/2;

            if( target == nums[mid] ){
                return mid;
            }

            if( target < nums[mid] ){
                hi = mid-1;
            }

            if( target > nums[mid] ){
                lo = mid+1;
            }
        }

        return -1;
    }

    /*
    this function apply search from both sides and check duplicate (c)
     */
    private int[] expand (int [] nums, int target, int targetIndex){
        int right = targetIndex+1;
        int left = targetIndex -1;
        while( right <= nums.length-1 && nums[right] == target){
            right ++;
        }
        while(left >= 0 && nums[left] == target){
            left --;
        }
        int [] answer = { ++left, --right};
        return answer;
    }


}