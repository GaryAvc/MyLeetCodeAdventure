class Solution {

    int answer;

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(25,9));
    }

    public int uniquePaths(int m, int n) {
        answer =0;

        uniquePathsHelper(m,n,0,0);

        return answer;
    }

    private void uniquePathsHelper( int row, int column, int startRow,int startColumn){

        // when it reach the target point
        if( startRow == row-1 && startColumn == column -1){
            answer++;
            return ;
        }

        // when it reach the edge, cut the branch, return
        if( startRow == row || startColumn == column ){
            return;
        }

        uniquePathsHelper( row,column,startRow+1,startColumn);
        uniquePathsHelper( row,column,startRow,startColumn+1);
    }

}