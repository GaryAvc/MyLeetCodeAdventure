import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {

//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        "ABCB"

//        char [][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String wor ="ABCCED";

//        [["C","A","A"],["A","A","A"],["B","C","D"]]
//        "AAB"
//        char [][] test = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String wor ="A";
        char [][] test = {{'B'}};
        String wor ="A";
//
//        char [][] test1 = {{'a'}};
//        String wor1 ="a";

//        char [][] test2 = {{'a'},{'a'}};
//        String wor2 ="aaa";

//        char [][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String wor ="ABCB";
        Solution s = new Solution();
        System.out.println(s.exist(test,wor));
    }

    boolean success=false;
    char[][] board;
    char[] wordArray;
    List<String> duplicate = new LinkedList<>();


    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.wordArray=word.toCharArray();

        if(word == null||word==""){
            return false;
        }

        for( int i=0;i< board.length;i++){
            for (int j=0;j< board[i].length;j++){
                if(dfs(0,i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs( int index, int x, int y){

        if(index== wordArray.length ){
            success=true;
            return true;
        }

        char target = wordArray[index];

        if( x<0|| y<0|| x>= board.length || y>= board[0].length || target!=board[x][y]){
            return false;
        }

        if( duplicate.contains( x+" "+y)){
            return false;
        }

        /*
        this part check if the x,y cordinate is valid
         */

        if(!success){
            duplicate.add(x+" "+y);
            boolean rt1 = dfs(index+1,x+1,y);
            boolean rt2 = dfs(index+1,x-1,y);
            boolean rt3 = dfs(index+1,x,y-1);
            boolean rt4 = dfs(index+1,x,y+1);
            duplicate.remove(duplicate.size()-1);
            return rt1||rt2||rt3||rt4;
        }else{
            return true;
        }

    }

}
