import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x = {4,5,6,7,0,1,2};
        int [] y = {5,1,3};
        System.out.println(s.search( y, 3));
    }

    public int search(int[] nums, int target) {

        /*
        Invirance:
        1. check if the left or right side in increasing
        2. check if the mid value is equal inside the while loop
        3. after checking the left, right -- check the target posision due to comparasion with ?
         */

        int lo = 0;
        int hi = nums.length-1;

        while( lo <= hi){

            int mid = lo + (hi-lo)/2;
            int midv = nums [mid];
            if (midv == target) {
                return mid ;
            }

            /*
            this if checks the whether the right or left side is increasing
             */

            /*
            the left part is increasing
             */

            if ( midv >= nums[lo]){

//                the target is in the increasing part, on the left
                if( target >= nums[lo] && midv > target){

                    hi = mid-1;

                }else{

                    lo = mid +1;

                }

            }
            /*
            the right is increasing
             */
            else{

                if( target > midv && target <= nums[hi]  ){
                    lo = mid +1;
                }else{
                    hi = mid -1;
                }
            }
        }
        return -1;

    }
}

