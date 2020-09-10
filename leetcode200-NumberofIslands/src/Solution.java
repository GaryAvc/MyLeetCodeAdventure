class Solution {

    int rowLen;
    int colLen;
    char[][] grids;

    /*
    Invariance:
        1. The basic idea is to find how many set of 1 that are connecting together
        2. The first idea is to write a (recursion) function that maybe use dfs / bfs to retrieve all the connecting 1, and turn it into maybe -1
        3. Loop the whole 2D array, when it reach 1, call the function and add answer 1
     */
    public int numIslands(char[][] grid) {


        if (grid.length==0 ){
            return 0;
        }

        int answer= 0;
        rowLen=grid.length;
        colLen=grid[0].length;
        grids=grid;

        // loop the whole array
        for( int row=0;row<grid.length;row++){
            for(int col =0;col<grid[row].length;col++){
                if(grid[row][col]=='1'){
                    dfs(row,col);
                    answer++;
                }
            }
        }


        return answer;
    }

    // when reach the edge or 0, return.
    private void dfs(int row,int col) {

        // base case: out of the edge / the value NOT equal to 1 (since we change the used 1 to 9)
        if(row<0 || col<0 || row>=rowLen || col>=colLen || grids[row][col]!='1'){
            return;
        }

        grids[row][col] = '9';

        // dfs recursion
        dfs(row-1,col);
        dfs(row,col-1);
        dfs(row,col+1);
        dfs(row+1,col);
    }
}