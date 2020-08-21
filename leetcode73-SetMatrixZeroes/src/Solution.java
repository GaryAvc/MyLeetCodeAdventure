class Solution {
    public void setZeroes(int[][] matrix) {
        int matrixRow = matrix.length;
        int matrixColumn = matrix[0].length;
        boolean colZero =false;


        for( int i =0; i <matrixRow;++i){
            for( int j =0;j<matrixColumn;j++){
                if( matrix[i][j] == 0){
                    if( j ==0){
                        matrix[0][0]=0;
                    }
                    if( i ==0){
                        colZero=true;
                    }
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for( int i =0; i <matrixRow;++i){
            for( int j =0;j<matrixColumn;j++){
                if( j ==0 && matrix[i][j]==0){
                    matrix[i][]
                }
            }
        }

    }


}