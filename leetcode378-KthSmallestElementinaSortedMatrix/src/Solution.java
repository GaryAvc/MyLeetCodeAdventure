class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix[0].length-1];

        while( left< right){

        }

    }

    public int helper(int k,int mid,int [][] matrix) {

        int row = matrix.length-1;
        int col = 0;

        int smaller = 0;

        while( row >= 0 && col < matrix[0].length){

            int val = matrix[row][col];
            smaller += row;

            if( val <= mid){
                col++;
            }else{
                row--;
            }
        }

        return smaller;

    }


}