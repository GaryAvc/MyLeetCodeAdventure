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
        backtrack(new LinkedList<>(),target,candidates,target,0);
        return answerList;
    }

    private void backtrack( List<Integer> cur, int remain,
                            int[] candidates, int target,int start){
        if(remain<0){
            return;
        }
        if(remain==0){
            answerList.add(new LinkedList<>(cur));
            return;
        }
        for( int i=start;i< candidates.length;++i){
            cur.add(candidates[i]);
            backtrack(cur,remain-candidates[i],candidates,target,i);
            cur.remove(cur.size()-1);
        }
    }
}