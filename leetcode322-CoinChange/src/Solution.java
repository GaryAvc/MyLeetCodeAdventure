import java.util.Arrays;

class Solution {

    int init;

    public int coinChange(int[] coins, int amount) {
        int min = 0;
        for( int c:coins){
            min = Math.min(c,min);
        }
        int [] result = new int[amount+1];
        Arrays.fill(result,amount+1);
        init = amount+1;

        return helper(coins,amount,result);

    }

    public int helper( int[] coins,int amount,int [] result){
        if(amount == 0){
            return 0;
        }

        if(amount<0){
            return -1;
        }

        if(result[amount]!=init){
            return result[amount];
        }

        for(int c:coins){

            int res = helper(coins,amount-c,result);
            if(amount-c>=0){
                result[amount-c] = res;
            }

            if( res>=0){
                result[amount] = Math.min(result[amount], res+1);
            }

        }

        if(result[amount]==init){
            return -1;
        }else{
            return result[amount];
        }


    }
}