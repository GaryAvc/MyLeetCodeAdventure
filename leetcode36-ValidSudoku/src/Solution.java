import java.util.HashSet;
import java.util.Set;

class Solution {

    /*
    Invirance:
    1. each row can NOT contain duplicated num
    2. each column can NOT contain duplicated nums
    3. in 9 of 3x3 grids, can NOT contain duplicated nums
     */

    public boolean isValidSudoku(char[][] board) {
        Set duplicate = new HashSet();
        for( int i =0;i<9;++i){
            for ( int j = 0;j<9;++j){
                char item = board[i][j];
                if ( item!='.'){
                    if( !duplicate.add(item + "row" + i ) ||
                            !duplicate.add(item + "column"  + j)||
                            !duplicate.add(item + " " + i/3 + " " + j/3 )){
                        return false;
                    }
                }

            }
        }

        return true;
    }

}