class Solution {

    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        int [][] pathValue = new int[row][column];

        return dp(pathValue,row,column,0,0,grid);
    }

    /*
        this function,
        1. create a new 2D arrays that contain all the values of path sums from BOTTOM up
        2. each index should compare the right and bottom value, and choose the smaller one
        and add it to itself
     */
    private int dp ( int[][] pathValue, int row, int column, int x, int y, int [][] grid){

        // when it reach the target/end of the grid
        if( x == row -1 && y == column -1 ){
            pathValue[x][y]= grid[x][y];
            return grid[x][y];
        }

        // when it reach the edge of the grid
        if( x == row || y == column){
            return -1;
        }

        // check if this index already contian value ( already been calculated),
        // if yes - return this value
        if ( pathValue[x][y] != 0 ){
            return pathValue[x][y];
        }

        // when this index is not pre-calculated
        int rightValue =dp(pathValue,row,column,x+1,y,grid);
        int bottomValue = dp(pathValue,row,column,x,y+1,grid);

        if( rightValue == -1 ){
            pathValue[x][y]=grid[x][y]+bottomValue;
            return pathValue[x][y];
        }
        if(bottomValue == -1){
            pathValue[x][y]=grid[x][y]+rightValue;
            return pathValue[x][y];
        }

        if( bottomValue > rightValue){
            pathValue[x][y]=grid[x][y]+rightValue;
            return pathValue[x][y];
        }else {
            pathValue[x][y]=grid[x][y]+bottomValue;
            return pathValue[x][y];
        }

    }
}