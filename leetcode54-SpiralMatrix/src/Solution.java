import java.util.LinkedList;
import java.util.List;

class Solution {

    int size;
    List<Integer> answer;

    public static void main(String[] args) {
        int[][] x = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution s = new Solution();
        s.spiralOrder(x);
        System.out.println(6000/180.0);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        answer=new LinkedList<>();
        if(matrix.length==0){
            return answer;
        }
        takingOutter(matrix.length*matrix[0].length,0,0,matrix,
                matrix[0].length, matrix.length);
        return answer;
    }

    /*
    this function is one round of takeing the outter nums
     */
    private void takingOutter(int remain,int startRow,int startColumn,int[][] matrix,int rowLength
    ,int columnLength){
        if( remain ==1){
            answer.add(matrix[startRow][startColumn]);
            return;
        }

        /*
        this part is left to right
         */
        for( int i=startColumn;i<startColumn+rowLength-1;++i){
            answer.add(matrix[startRow][i]);
            remain--;
            if(remain==0){
                return;
            }
        }
         /*
        this part is top to bottom
         */
        for( int i=startRow;i<startRow+columnLength-1;++i){
            answer.add(matrix[i][startColumn+rowLength-1]);
            remain--;
            if(remain==0){
                return;
            }
        }
         /*
        this part is right to left
         */
        for( int i=startColumn+rowLength-1;i>startColumn;--i){
            answer.add(matrix[startRow+columnLength-1][i]);
            remain--;
            if(remain==0){
                return;
            }
        }
         /*
        this part is bottom to top
         */
        for( int i=startRow+columnLength-1;i>startRow;--i){
            answer.add(matrix[i][startColumn]);
            remain--;
            if(remain==0){
                return;
            }
        }
        takingOutter(remain,startRow+1,startColumn+1,matrix,rowLength-2,columnLength-2);
    }

}