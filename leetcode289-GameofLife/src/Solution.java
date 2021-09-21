class Solution {

    public static void main(String[] args) {
        int[][]test1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        Solution s = new Solution();
        s.gameOfLife(test1);
    }
    public void gameOfLife(int[][] board) {

//        copy the original matrix
        int [][] helperMatrix = new int[board.length][board[0].length];

        for( int row =0;row<board.length;row++) {
            for (int col = 0; col < board[row].length; col++) {
                helperMatrix[row][col] = board[row][col];
            }
        }


//        iterate through all element in board
        for( int row =0;row<board.length;row++){
            for(int col = 0;col<board[row].length;col++){

                int count=0;

//                if the cell is dead
                if(board[row][col]==1){
                    count = helper(row,col,helperMatrix)-1;
                    if(count<2 || count>3){
                        board[row][col]=0;
                    }
                }else{
                    count = helper(row,col,helperMatrix);
                    if(count==3){
                        board[row][col]=1;
                    }
                }
//                if the cell is alive

            }
        }
    }

//    return the counting num of the live neiborhood cell,
    public int helper(int row,int col, int[][] board){
        int count = 0;

        for(int lr = row-1; lr<=row+1;lr++){
            for(int hc = col-1;hc<=col+1;hc++){

                if(lr <0 || lr>=board.length||hc<0||hc>=board[lr].length){
                    continue;
                }

                if(board[lr][hc]==1){
                    count++;
                }

            }
        }

        return count;
    }
}