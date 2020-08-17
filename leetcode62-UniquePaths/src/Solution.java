import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {


    int[][] path;


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(25,9));
    }

    public int uniquePaths(int m, int n) {
        int answer =0;

        path =new int[m][n];

        answer = dp(m,n,0,0);

        return answer;
    }

    private int dp(int m,int n,int x , int y){

        if( x == m || y == n){
            return 0;
        }

        // if this position has been calculated and filled with numbers, just return this num
        if(path[x][y] !=0){
            return path[x][y];
        }

        // if it reach the target, set it to 0, and return 0
        if(x==m-1 && y==n-1  ){
            path[x][y] = 0;
            return 1;
        }

        path[x][y] += dp(m,n,x+1,y);
        path[x][y] +=dp(m,n,x,y+1);
        return path[x][y];


    }


}