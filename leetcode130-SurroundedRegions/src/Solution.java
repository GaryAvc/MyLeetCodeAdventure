import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        char [][]x={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char [][]y={{'O','O'},{'O','O'}};
        Solution s = new Solution();
        s.solve(y);
    }

    Queue<int[]> answer;
    int rowLength;
    int columnLength;
    char[][] board;


    public void solve(char[][] board) {

        if( board.length == 0){
            return;
        }

        answer = new ArrayDeque<>();
        columnLength = board.length;
        rowLength=board[0].length;
        this.board = board;

        for( int x=0;x<columnLength;++x){
            if(board[x][0]=='O'){
                checkSurrounding(x,0,"");
            }
            if(board[x][columnLength-1]=='O'){
                checkSurrounding(x,columnLength-1,"");
            }
        }

        for( int y =1;y<rowLength-1;++y){
            if(board[0][y]=='O'){
                checkSurrounding(0,y,"");
            }
            if(board[rowLength-1][y]=='O'){
                checkSurrounding(rowLength-1,y,"");
            }
        }

        for( int x=0;x<columnLength;x++){
            for( int y=0;y<rowLength;y++){
                board[x][y]='X';
            }
        }

        while( answer.size()!=0){
            int[] index = answer.poll();
            board[index[0]][index[1]]='O';
        }
    }

    // this function take in a 'O' and check its surrounding is 'O',
    // if yes, push into 'O' array, if not, return
    public void checkSurrounding(int row, int col,String lastStatus){

        // basecase : when out of bounds
        if(!(row >=0 && col >=0 && row <columnLength && col <  rowLength) ){
            return;
        }

        if( board[row][col] == 'O'){

            int [] oIndex = new int[2];
            oIndex[0]=row;
            oIndex[1]=col;

            if( !answer.contains(oIndex)){
                answer.add(oIndex);
            }else{
                return;
            }

            if(!lastStatus.equals("right")){
                checkSurrounding(row-1,col,"left");
            }
            if(!lastStatus.equals("top")){
                checkSurrounding(row,col-1,"down");
            }
            if(!lastStatus.equals("left")){
                checkSurrounding(row+1,col,"right");
            }
            if(!lastStatus.equals("down")){
                checkSurrounding(row,col+1,"top");
            }

        }else{
            return;
        }
    }

}