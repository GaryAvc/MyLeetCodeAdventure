class Solution {

    /*
        Invariance:
            1. DP
            2. The basic idea is that, finding the small case is that when max(0,i-1) <0
            , Make a new array DP[], which store the maximum value that possible at i,
            i-1 position store the possible maximum value that can be store at i-1, which is
            also the same as i.
            3. when DP[i-1] <0, make DP[i] = A[i], is DP[i-1]>0, make DP[i] = A[i] + DP[i-1]
     */
    public int maxSubArray(int[] nums) {

        int [] dp = new int[nums.length];
        dp[0]= nums[0];
        int answer = dp[0];

        for(int i=1;i<nums.length;i++){

            dp[i] = dp[i-1]<0? nums[i] : dp[i-1] + nums[i];
            answer = Math.max(answer, dp[i]);
        }

        return answer;

    }

}