import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        char [][]x={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char [][]y =
                {{'O','O'},{'O','O'}};
        Solution s = new Solution();
        s.solve(y);
    }

    /*
    Invirance:
        1. any 'O' on the border of the board are not flipped to 'X'
        2. Any 'O' that is not on the border and
         it is not connected to an 'O' on the border will be flipped to 'X'.
        3. Two cells are connected if they are adjacent cells connected horizontally or vertically.
    */

    Map<Integer,Integer> oindex;

    public void solve(char[][] board) {

        if( board.length<=1){
            return;
        }

        oindex = new HashMap<>();
        /*
        this part find all 'O' on the border and store it in a MAP
         */
        int bottomRow = board.length;
        int rightestColumn = board[0].length;



        // from left to right, row 0
        for ( int i=0;i<rightestColumn;i++){
            if( board[0][i] == 'O'){
                oindex.put(0,i);
                addoConnected(0,i,board);
            }
        }
        // from left to right, row bottom Row
        for ( int i=0;i<rightestColumn;i++){
            if( board[bottomRow-1][i] == 'O'){
                oindex.put(bottomRow-1,i);
                addoConnected(bottomRow-1,i,board);
            }
        }
        // from top to bottom, column 0
        for ( int i=0;i<bottomRow;i++){
            if( board[i][0] == 'O'){
                oindex.put(i,0);
                addoConnected(i,0,board);
            }
        } // from top to bottom, column rightest column
        for ( int i=0;i<bottomRow;i++) {
            if (board[i][rightestColumn-1] == 'O') {
                oindex.put(i, rightestColumn-1);
                addoConnected(i,rightestColumn-1,board);
            }
        }


        for( int i =0;i< board.length;i++){
            for (int j =0;j< board[0].length;j++){
                board[i][j]='X';
            }
        }

       for( Map.Entry<Integer,Integer> entry : oindex.entrySet()){
           board[ entry.getKey()][entry.getValue()] = 'O';
       }

    }

    /*
    this function add all conntected 'O' in the the oindex map
     */
    private void addoConnected ( int row, int column,char[][] board){
        int bottomRow = board.length;
        int rightestColumn = board[0].length;
        if( row-1 > -1  && board[row-1][column]=='O'){
            if( !oindex.containsKey( row-1)){
                oindex.put( row-1,column);
            }
        }
        if( row+1 < bottomRow  && board[row+1][column]=='O'){
            if( !oindex.containsKey( row+1)){
                oindex.put( row+1,column);
            }
        }
        if( column-1 > -1  && board[row][column-1]=='O'){
            if (!oindex.containsValue(column-1)) {
                oindex.put( row,column-1);
            }
        }
        if( column+1 < rightestColumn  && board[row][column+1]=='O') {
            if (!oindex.containsValue(column+1)) {
                oindex.put(row, column+1);
            }
        }
    }
}
