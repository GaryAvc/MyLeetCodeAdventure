import java.util.HashSet;
import java.util.Set;

class Solution {

    /*
    Invirance:
    1. each row can NOT contain duplicated num
    2. each column can NOT contain duplicated nums
    3. in 9 of 3x3 grids, can NOT contain duplicated nums
     */

    boolean isValid;

    public boolean isValidSudoku(char[][] board) {
        isValid = true;

        if( !isRowValid(board)){
            return  false;
        }

        if( !isColumnValid(board)){
            return  false;
        }

        int[][] set = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};

        for( int[] i : set){
            if( !isSubValid(board,i[0],i[1]) ){
                return  false;
            }
        }
        return true;
    }

    /*
    this function check each sub-3x3 is valid or not
     */
    private boolean isSubValid( char[][] board, int row,int column){
        Set duplicate = new HashSet<>();
        for( int i = row;i< row+3;++i){
            for ( int j = column; j<column+3;++j){
                if( board[i][j] != '.') {
                    if (!duplicate.contains(board[i][j])) {
                        duplicate.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private boolean isColumnValid(char[][] board) {

        for ( int i =0;i< board.length;++i){
            Set duplicate = new HashSet<>();
            for ( int j = 0; j < board[i].length;++j){
                if( board[j][i] != '.'){
                    if( !duplicate.contains( board[j][i]  )){
                        duplicate.add(board[j][i]);
                    }else{
                        return false;
                    }
                }

            }
        }
        return true;
    }

    /*
    this function check each row of the board can be valid or not
     */
    private  boolean isRowValid ( char[][] board) {

        for ( int i =0;i< board.length;++i){
            Set duplicate = new HashSet<>();
            for ( int j = 0; j < board[i].length;++j){
                if( board[i][j] != '.'){
                    if( !duplicate.contains( board[i][j]  )){
                        duplicate.add(board[i][j]);

                    }else{
                        return false;
                    }
                }

            }
        }
        return true;
    }
}