import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {

        /*
        this part take each row items out and store in a arraylist
         */
        Queue<Integer> items = new LinkedList<>();
        int n = matrix.length;
        for(int i = 0; i < n; ++i){
            for( int j=0;j<n;++j){
                items.add(matrix[i][j]);
            }
        }

        for(int i = n-1; i> -1; --i) {
            for (int j = 0; j < n; ++j) {
                matrix[j][i] = items.poll();
            }
        }

    }
}