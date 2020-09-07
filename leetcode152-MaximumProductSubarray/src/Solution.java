class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = {-2};
        s.maxProduct(x);
    }

    /*
    Invariance:
        1. 2 negative nums mul together can be positive
        2. the time result should compare with the biggest num in the array
        3. loop the array, hold one variable for max Single nums, one max product for the max product
        4. 3 adjcent also count, where range from 1 to length-2
        5. assign 1 more memory to store the 3 max Value
     */


    public int maxProduct(int[] nums) {

        int maxNum=Integer.MIN_VALUE;
        int maxProduct = Integer.MIN_VALUE;
        int maxThree = Integer.MIN_VALUE;

        // loop the array to record the max product, and max num but left the last one uncount
        for ( int i=0;i<nums.length;i++){


            maxNum=Math.max(maxNum,nums[i]);

            // 2 nums production
            if(i<nums.length-1){
                int product = nums[i]*nums[i+1];
                maxProduct=Math.max(maxProduct,product);
            }

            // 3 nums production
            if( i >=1 && i<=nums.length-2){
                maxThree = Math.max(maxThree, nums[i-1]*nums[i]*nums[i+1]);
            }

        }

        return  Math.max(Math.max(maxNum,maxProduct),maxThree);
    }

}