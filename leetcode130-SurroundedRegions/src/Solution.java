import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // problem 130 prev
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

    Map<Integer, ArrayList<Integer>> oindex;

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
                if( oindex.containsKey(0)){
                    oindex.get(0).add(i);
                }else{
                    ArrayList<Integer> everyRow = new ArrayList<>(i);
                    oindex.put( 0,everyRow);
                }
                addoConnected(0,i,board);
            }
            if( board[bottomRow-1][i] == 'O'){
                if( oindex.containsKey(bottomRow-1)){
                    oindex.get(bottomRow-1).add(i);
                }else{
                    ArrayList<Integer> everyRow = new ArrayList<>(i);
                    oindex.put( bottomRow-1,everyRow);
                }
                addoConnected(bottomRow-1,i,board);
            }
        }
        // from top to bottom, column 0
        for ( int i=0;i<bottomRow;i++){
            if( board[i][0] == 'O') {
                if (oindex.containsKey(i)) {
                    oindex.get(i).add(0);
                } else {
                    ArrayList<Integer> everyRow = new ArrayList<>(0);
                    oindex.put(i, everyRow);
                }
                addoConnected(i, 0, board);
            }

            if( board[i][rightestColumn-1] == 'O'){
                if( oindex.containsKey(i)){
                    oindex.get(i).add(rightestColumn-1);
                }else{
                    ArrayList<Integer> everyRow = new ArrayList<>(rightestColumn-1);
                    oindex.put( i,everyRow);
                }
                addoConnected(i,rightestColumn-1,board);
            }

        }

        for( int i =0;i< board.length;i++){
            for (int j =0;j< board[0].length;j++){
                board[i][j]='X';
            }
        }

       /*
       This part set all the 'O' in map which its index, and make it into board
        */
        for( Map.Entry<Integer,ArrayList<Integer>> entry : oindex.entrySet()){
            for( int i =0; i < entry.getValue().size();++i){
                board[entry.getKey()][entry.getValue().get(i)]='O';
            }

        }

    }

    /*
    this function add all conntected 'O' in the the oindex map
     */
    private void addoConnected ( int row, int column,char[][] board){
        int bottomRow = board.length;
        int rightestColumn = board[0].length;
        if( row-1 > -1  && row+1 < bottomRow  && column-1 > -1  &&
                column+1 < rightestColumn  && board[row][column]=='O') {

                if( oindex.containsKey(row)){
                    oindex.get(row).add(column);
                }else{
                    ArrayList<Integer> everyRow = new ArrayList<>(row);
                    oindex.put( row,everyRow);
                }
        }
        addoConnected( row-1,column,board);
        addoConnected( row+1,column,board);
        addoConnected( row-1,column-1,board);
        addoConnected( row-1,column+1,board);
    }
}
