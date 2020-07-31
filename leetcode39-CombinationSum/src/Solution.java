import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s= new Solution();
        int []can = {2,3,5};
        int tar = 8;
        System.out.println(s.combinationSum(can,8));
    }

    List<List<Integer>> answerList = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        bfs(0,target,candidates, new LinkedList<Integer>());
        return answerList;
    }

    private void bfs(int sum, int target, int[]candidates
            , List<Integer> candidateCombination){
        if( sum > target){
            return;
        }

        if( sum == target){
            answerList.add(candidateCombination);
            return;
        }else{
            for( int i :candidates){
                candidateCombination.add(i);
                bfs(sum+=i,target,candidates,candidateCombination);
//            candidateCombination.remove(candidateCombination.size()-1);
            }
        }
    }
}