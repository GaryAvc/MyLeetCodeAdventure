class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] x = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},
                {8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},
                {8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},
                {6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},
                {9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},
                {4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},
                {0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},
                {6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},
                {3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
        System.out.println(s.minPathSum(x));

    }


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

        if( rightValue == -1){
            return grid[x][y]+bottomValue;
        }
        if(bottomValue == -1){
            return grid[x][y]+rightValue;
        }

        if( bottomValue > rightValue){
            return  grid[x][y]+rightValue;
        }else {
            return  grid[x][y]+bottomValue;
        }

    }
}