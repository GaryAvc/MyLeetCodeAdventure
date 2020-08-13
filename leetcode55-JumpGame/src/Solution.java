import java.util.Arrays;
import java.util.Collections;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x= {3,2,1,0,4};
        int[]y={1,2,3};
        s.canJump(y);

    }

    boolean canReach;

    public boolean canJump(int[] nums) {
        canReach = false;
        canJumpHelper(nums,0);

        return canReach;
    }

    /*
    this function Recursively test each cases,
    if it can reach the end, make canReach: true
    if can Reach == true, return
    if all is false, do nothing
     */
    private void canJumpHelper(int[] nums,int start){
        if( canReach){
            return;
        }

        if( start + nums[start] >=nums.length-1){
            canReach = true;
        }

        if( nums[start] == 0){
            return;
        }

        for ( int i=0; i<nums[start];++i){
            canJumpHelper(nums, start+1+ i);
        }
    }

}