/*
Invariance:
    1. first traverse through the array and turn 1 into -1
    2. set the target value to 1, for a easy furthur use
    3. use a dp to recursively calculate the value of the of the starting point, return the start val
    4. dp function:
        1. add the value from the right and bottom
        2. if the right and bottom is out of the bound OR value is -1, then just return the value as 0
 */
class Solution {

    private int rowLength;
    private int colLength;
    private int[][] grid;
    private int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        rowLength = obstacleGrid.length;
        colLength = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        grid = new int[rowLength][colLength];

        // initial the target value to be 1
        grid[rowLength-1][colLength-1]=1;

//        // initial the grid to set the obstacle value from 1 to -1
//        for(int row = 0;row<obstacleGrid.length;row++){
//            for(int col =0;col<obstacleGrid[row].length;col++){
//                if(obstacleGrid[row][col]==1){
//                    obstacleGrid[row][col]= -1;
//                }
//            }
//        }
//


        return dp(0,0);
    }

    private int dp(int row, int col) {

        // base case: 1. when it is out of the bound, 2. when it is a obstacle - return 0
        if( row >= rowLength || col >= colLength || obstacleGrid[row][col]==1){
            return 0;
        }

        int num ;
        // store the value into the new grid, if it already contain any value, just use it
        if( grid[row][col]!=0){
            return grid[row][col];
          }else{
            num =  dp(row+1,col)+dp(row,col+1);
            grid[row][col] = num;
            return num;
        }
    }

    public static void main(String[] args) {

int [][]x ={{0,0,0},{0,1,0},{0,0,0}};
Solution s  =new Solution();
s.uniquePathsWithObstacles(x);
    }
}