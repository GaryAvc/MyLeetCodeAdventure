class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int buydate = 0;
        int profit=0;
        int selldate  = 0;

        for(int i = 0;i<prices.length-1;i++){
            if(prices[i]<buy){
                buy = prices[i];
                buydate = i;
            }

            if( profit< prices[i] -prices[buydate]){
                profit = prices[i] -prices[buydate];
                selldate  = i;
            }
        }

        if(profit<0){
            return 0;
        }else{
            return profit;
        }
    }

    public static void main(String[] args) {
        int [] x = {1,2};
        Solution s =  new Solution();
        s.maxProfit(x);
    }

}