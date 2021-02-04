class Solution {

    /*
    Invariance:
    1. the basic idea is that the answer for N item is equal to the the DP[N-1]+DP[N-2]
    since the idea is that, it take one more step to go to final and 2 more steps to final
    from either dp[n-1] or dp[n-2]

     */
    public int climbStairs(int n) {

    int [] dp = new int[n];

    dp[0] = 1;
    dp[1] = 1 ;

    if( n==0||n==1){
        return n;
    }

    for ( int i = 2;i<n;i++){
        dp[i] = dp[i-1]+dp[i-2];
    }

    return dp[n-1];

    }



}