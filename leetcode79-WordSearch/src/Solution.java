import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        Solution s= new Solution();
//        "ABCCED"
//        char[][] charSet = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word ="ABCCED";
//        char[][] charSet = {{'A'},{'A'}};
//        String word ="AAA";
//        char[][] charSet = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String word ="AAB";
//        [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//        "ABCESEEEFS"
        char[][] charSet = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word ="ABCESEEFS";

        System.out.println(charSet[0].length);

        System.out.println(s.exist(charSet,word));
    }

    boolean answer = false;
    boolean doesConatin = false;
    Set<Boolean>answerSet = new HashSet<>();

    public boolean exist(char[][] board, String word) {

        char[] charWord = word.toCharArray();

        for (int row = 0; row < board.length; ++row) {
            for (int column = 0; column < board[row].length; ++column) {
                if (board[row][column] == charWord[0]) {
                    bfs(charWord.length, new HashSet<String>(), board, charWord, row, column);
                    if (answer == true) {
                        break;
                    }
                }
            }
        }

        return answer;
    }

    /*
    that is a backtrack to find if it can be a possible word between the board
     */
    private void bfs(int remain, Set<String> charSet, char[][] board, char[] word, int x, int y) {

        if (remain == 1) {
            answer = true;
            return;
        }

        char target = word[word.length - remain+1];


        if ( y<board[x].length-1 && x!=0 && board[x-1][y + 1] == target) {
            if(checkDuplicate(charSet,x-1,y+1)){
                return;
            }
            charSet.add(x + "-" + (y));
            bfs(remain - 1, charSet, board, word, x-1, y + 1);
            charSet.remove(charSet.size() - 1);
        }

        if ( y!=board[x].length-1&& x!= board.length-1 && board[x+1][y + 1] == target) {
            if(checkDuplicate(charSet,x+1,y+1)){
                return;
            }
            charSet.add(x + "-" + (y));
            bfs(remain - 1, charSet, board, word, x+1, y + 1);
            charSet.remove(charSet.size() - 1);
        }

        if ( y!=0 && x!=0 && board[x-1][y -1] == target) {
            if(checkDuplicate(charSet,x-1,y-1)){
                return;
            }
            charSet.add(x + "-" + (y));
            bfs(remain - 1, charSet, board, word, x-1, y - 1);
            charSet.remove(charSet.size() - 1);
        }

        if ( y!=0 && x!= board.length-1 && board[x+1][y - 1] == target) {
            if(checkDuplicate(charSet,x+1,y-1)){
                return;
            }
            charSet.add(x + "-" + (y));
            bfs(remain - 1, charSet, board, word, x+1, y - 1);
            charSet.remove(charSet.size() - 1);
        }


            if ( y!=board[x].length-1 && board[x][y + 1] == target) {
                if(checkDuplicate(charSet,x,y+1)){
                    return;
                }
                charSet.add(x + "-" + (y));
                bfs(remain - 1, charSet, board, word, x, y + 1);
                charSet.remove(charSet.size() - 1);
            }

            if (  y!=0 && board[x][y - 1] == target) {
                if(checkDuplicate(charSet,x,y-1)){
                    return;
                }
                charSet.add(x + "-" + (y));
                bfs(remain - 1, charSet, board, word, x, y - 1);
                charSet.remove(charSet.size() - 1);
            }
            if (x!= board.length-1 &&board[x + 1][y] == target) {
                if(checkDuplicate(charSet,x+1,y)){
                    return;
                }
                charSet.add((x) + "-" + y);
                bfs(remain - 1, charSet, board, word, x + 1, y);
                charSet.remove(charSet.size() - 1);
            }
            if ( x !=0 && board[x - 1][y] == target) {
                if(checkDuplicate(charSet,x-1,y)){
                    return;
                }
                charSet.add((x) + "-" + y);
                bfs(remain - 1, charSet, board, word, x - 1, y);
                charSet.remove(charSet.size() - 1);
            }

            return;


    }


    private boolean checkDuplicate(Set<String> duplicate,int a, int b){
        if (duplicate.contains(a + "-" + b)) {
            return true;
        } else {
            return false;
        }
    }
}