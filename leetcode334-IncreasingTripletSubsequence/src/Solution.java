class Solution2 {

    public static void main(String[] args) {

        Solution2 s = new Solution2();
        int [] test = {1,5,0,4,1,3};
        s.increasingTriplet(test);
    }
    public boolean increasingTriplet(int[] nums) {

//        boolean answer= false;
        for(int j = 0;j<nums.length-2;j++){
            if(helper(j,nums)){
                return true;
            }
        }



        return false;

    }

    public boolean helper( int start, int [] nums){
        int count =0;
        int small = nums[start];

        for(int i = start;i<nums.length;i++){

            if(nums[i]>small){
                count++;
                small = nums[i];
            }
        }

        if( count>=2){
            return true;
        }

        return false;
    }
}