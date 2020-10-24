/*

 */
class Solution {
    public int numTrees(int n) {

        return dp(n);
    }

    private int dp(int n) {
        if( n ==1){
            return 1;
        }
        int num = (n-2)>=0 ? n-2:0;
        return dp(n-1)*2+num;
    }


}