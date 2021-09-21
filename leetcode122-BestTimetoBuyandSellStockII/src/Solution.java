class Solution {
    public int maxProfit(int[] prices) {

        int [][] matrix = new int [prices.length][prices.length];

        matrix[prices.length-1][prices.length-1] = 0;

        for (int i= prices.length-2;i>=0;i--){
            for (int j=0;j<prices.length;j++){
                if( i ==j){
                    matrix[i][j] = 0;
                }else{
                    int val = 0;
                    for( int k =0;k< prices.length;k++){
                        val = Math.max( val, matrix[i+1][k] + prices[j] - prices[k]);
                    }
                }
            }
        }
        return matrix[0][prices.length-1];
    }

    public static void main(String[] args) {
        int [] x = {7,1,5,3,6,4};
        Solution s =  new Solution();
        s.maxProfit(x);
        System.out.println("x");
    }
}