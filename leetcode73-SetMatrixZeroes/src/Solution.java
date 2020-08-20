class Solution {
    public void setZeroes(int[][] matrix) {
        int matrixRow = matrix.length;
        int matrixColumn = matrix[0].length;


        for( int i =0; i <matrixRow;++i){
            for( int j =0;j<matrixColumn;j++){
                if( matrix[i][j] == 0){
                    matrix = mark( matrix,i,j);
                }
            }
        }

        for( int i =0; i <matrixRow;++i){
            for( int j =0;j<matrixColumn;j++){
                if( matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j]=0;
                }
            }
        }

    }

    /*
    this function take row, column and replace the item in it with MAX_Value
    since the max value it can appear is 10^9 which is absolutely less than MAX_Value
     */
    private int[][] mark (int [][]matrix,int row,int column){

        int matrixRow = matrix.length;
        int matrixColumn = matrix[0].length;

        for( int j =0;j<matrixColumn;j++){
            if( matrix[row][j] == 0 && j!=column){
                matrix = mark( matrix,row,j);
            }
            matrix[row][j] = Integer.MAX_VALUE;
        }

        for( int i =0; i <matrixRow;++i){
            if( matrix[i][column] == 0 && i!=row){
                matrix = mark( matrix,i,column);
            }
            matrix[i][column] = Integer.MAX_VALUE;
        }

        return matrix;
    }
}