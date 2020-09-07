class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[]x={1,2,5,-1,0,-3};
        System.out.println(s.maxProduct(x));
    }
    /*
    Invariance:
        1. make a record of max value, min value
        2. start from index 1 to the end of the array
        3.
     */
    public int maxProduct(int[] nums) {

        int answer = nums[0];
        int max = nums[0];
        int min =nums[0];

        for( int i =1;i<nums.length;++i){

            int temp = max;
            // when
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);

            if( answer < max){
                answer = max;
            }
        }

        return answer;

    }
}