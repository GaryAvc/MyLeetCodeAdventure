import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x = {4,5,6,7,0,1,2};

        System.out.println(s.search( x, 3));
    }

    public int search(int[] nums, int target) {

        if( nums.length ==0 ){
            return -1;
        }

        if( nums .length ==1 ){
            return nums[0] == target ? 0 : -1;
        }

        int lo = 0;
        int hi = nums.length-1;

        while(lo<hi){

            int mid = lo + (hi-lo)/2;

            int lov = nums[lo];
            int midv = nums[mid];

            if( midv == target){
                return mid;
            }

            if( lo == hi-1){
                if ( nums[hi]==target){
                    return hi;
                }
                break;
            }

            if( (midv >=lov) && ( target >=lov) ){

                if( target < midv){
                    hi = mid;
                }else{
                    lo = mid;
                }

            }else{

                if( midv > target){
                    lo = mid +1;
                }else{
                    hi = mid -1;
                }

            }

        }

        return -1;
    }
}

