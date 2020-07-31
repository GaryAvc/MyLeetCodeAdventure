import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x = {2,3,5};
        s.combinationSum(x,8);
    }
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(candidates, target, list);
        return lists;
    }

    private void process(int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                list.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                process( candidates, target - candidates[i], list);

            }
        }

    }
}