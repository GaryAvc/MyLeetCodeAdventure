class Solution {
    /*
    Invariance :
        1. since is already in ascend order, i was thinking about using the binary search
        2. which implmenet the tricky idea
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        // initial the
        if(matrix.length==0){
            return false;
        }
        int row =0;
        int col = matrix[0].length-1;

        while( row < matrix.length && col>=0 ){
            int value = matrix[row][col];
            if(target == value){
                return true;
            }
            if(target> value){
                row++;
                continue;
            }else if (target<value ){
                col--;
                continue;
            }
        }

        return false;
    }
}