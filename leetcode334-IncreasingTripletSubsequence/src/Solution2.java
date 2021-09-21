class Solution {

    public static void main(String[] args) {

        int [] test = {100,1,4,2,3};
        Solution s = new Solution();
        s.increasingTriplet(test);
    }

    public boolean increasingTriplet(int[] nums) {


        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for( int num:nums){
            if(num<=min){
                min = num;
            }else if (num < secMin){
                secMin = num;
            }else if (num >secMin){
                return true;
            }
        }

        return false;
    }
}