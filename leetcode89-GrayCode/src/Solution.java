import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.grayCode(2));
    }

    List<Integer> answerNum;
    int n;
    List<Integer> temp;
    List<List<Integer>> answer;

    public List<Integer> grayCode(int n) {
        this.n=n;
        temp = new LinkedList<Integer>();
        answer = new LinkedList<>();
        answerNum = new LinkedList<>();
        if( n==0){
            temp.add(0);
            return temp;
        }

        dfs(0);
        translate();

        return answerNum;
    }

    private void dfs( int record ) {
        if(record == n){
            answer.add(new LinkedList<>(temp));
            return;
        }

        temp.add(0);
        dfs( record+1);
        temp.remove(temp.size()-1);

        temp.add(1);
        dfs( record+1);
        temp.remove(temp.size()-1);
    }

    private void translate() {

        for(int outter=0;outter<answer.size();++outter){
            int innerTotalValue=0;
            for( int inner = 0;inner<answer.get(outter).size();++inner){
                int innerVlaue = answer.get(outter).get(inner);
                if(innerVlaue==1){
                    innerTotalValue+= 1* Math.pow( 2 , answer.get(outter).size()-inner-1);
                }
            }
            answerNum.add(innerTotalValue);
        }

    }
}