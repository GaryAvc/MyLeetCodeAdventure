import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {

//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        "ABCB"

//        char [][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String wor ="ABCCED";
//
//        char [][] test1 = {{'a'}};
//        String wor1 ="a";

//        char [][] test2 = {{'a'},{'a'}};
//        String wor2 ="aaa";

        char [][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String wor ="ABCB";
        Solution s = new Solution();
        s.exist(test,wor);
    }

    boolean success=false;
    char[][] board;
    char[] wordArray;
    Set<String> duplicate = new HashSet<>();


    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.wordArray=word.toCharArray();

        if(word == null||word==""){
            return false;
        }
        if(word.length()==1 && !(wordArray[0]==(board[0][0]))){
            return false;
        }

        for( int i=0;i< board.length;i++){
            for (int j=0;j< board[i].length;j++){
                if(dfs(wordArray.length-1,i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs( int remain, int x, int y){

        char target = wordArray[wordArray.length-remain];

        if( x<0|| y<0|| x>= board.length || y>= board[0].length){
            return false;
        }

        if(remain==1 && target == board[x][y] ){
            success=true;
            return true;
        }

        /*
        this part check if the x,y cordinate is valid
         */


        if( duplicate.contains( x+" "+y)){
            return false;
        }
        if(board[x][y]!=target){
            return false;
        }

        if(!success){
            duplicate.add(x+" "+y);
            boolean rt1 = dfs(remain-1,x+1,y);
            boolean rt2 = dfs(remain-1,x-1,y);
            boolean rt3 = dfs(remain-1,x,y-1);
            boolean rt4 = dfs(remain-1,x,y+1);
            duplicate.remove(duplicate.size()-1);
            return rt1||rt2||rt3||rt4;
        }else{
            return true;
        }

    }

}
