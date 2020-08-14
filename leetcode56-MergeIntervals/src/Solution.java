import javax.swing.text.Document;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int [][]x=
                {{1,3},{2,6},{8,10},{15,18}};
        int[][]y={{1,4},{0,0}};
        Solution s = new Solution();
        s.merge(y);
    }
    int[][] answer;
    int size;

    public int[][] merge(int[][] intervals) {

        if( intervals.length==0 || intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        size=1;
        mergeHelper(1,intervals,0);
        answer=new int[size][2];
        System.arraycopy(intervals,0,answer,0,size);

        return answer;

    }

    private void mergeHelper(int intervalIndex,int [][] intervals,int answerIndex) {

        if( intervalIndex == intervals.length){
            return;
        }

        int intervalLeft = intervals[intervalIndex][0];
        int intervalRight= intervals[intervalIndex][1];
        int answerLeft = intervals[answerIndex][0];
        int answerRight= intervals[answerIndex][1];

        /*
        overlap
         */
        if( intervalLeft <= answerRight){
            int [] overlapInterval = {Math.min(answerLeft,intervalLeft),Math.max(answerRight,intervalRight)};
            intervals[answerIndex] = overlapInterval;
            mergeHelper(intervalIndex+1,intervals,answerIndex);

        }else{
            intervals[answerIndex+1] = intervals[intervalIndex];
            size++;
            mergeHelper(intervalIndex+1,intervals,answerIndex+1);
        }


    }
}