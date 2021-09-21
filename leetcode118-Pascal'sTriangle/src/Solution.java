import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generate(5);
        System.out.println(s);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> rownum = new ArrayList<Integer>();
        rownum.add(1);
        answer.add(rownum);
        for(int i =1;i<numRows+1;i++){
            // List<Integer> rn = new ArrayList<Integer>();
            // rn = build(i,rownum)
            answer.add(build(i,answer.get(i-1)));
        }

        return answer;


    }

    public List<Integer> build(int row, List<Integer> lastrow){
//         base case:1,2
        List<Integer> rownum = new ArrayList<Integer>();
        // if(row ==1){
        //     rownum.add(1);
        // }else
        if (row ==2){
            rownum.add(1);
            rownum.add(1);
        }else{

            rownum.add(1);

            for(int i=0;i<lastrow.size()-1;i++){
                rownum.add(lastrow.get(i) +lastrow.get(i+1));
            }

            rownum.add(1);
        }
        return rownum;
    }
}