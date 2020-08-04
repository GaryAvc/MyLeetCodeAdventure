import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x = {4,5,6,7,0,1,2};

        System.out.println(s.search( x, 5));
    }
    int answerIndex;
    int [] nums;

    public int search(int[] nums, int target) {
        this.nums = nums;
        answerIndex = binarySearch(0,target,nums.length-1);
        return answerIndex;
    }

    private int binarySearch( int start, int targetv, int end){

        int length =end-start+1;

        if(length==1){
            return start;
        }

        int middle = start + length/2;

        if( nums[middle] == targetv ){
            return middle;
        }

        if( nums[middle] > targetv ){
            return binarySearch( start, targetv,middle);
        }else if(nums[middle]<targetv){
            return binarySearch(middle,targetv,end);
        }

        return -1;
    }



}

