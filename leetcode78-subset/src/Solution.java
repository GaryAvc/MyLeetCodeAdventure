import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums ={1,2,3};
        System.out.println(s.subsets(nums));
    }

    List<List<Integer>> answer = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {

        answer.add(new LinkedList<>());

        for( int i=1;i<=nums.length;i++){
            dfs(new LinkedList<>(), nums,i,0);
        }

        return answer;
    }

    private void dfs(List<Integer>temp, int []nums, int remain, int start){

        if(remain == 0){
            answer.add(new LinkedList<>(temp));
            return;
        }

        for(int i=start;i<nums.length;++i){
            temp.add(nums[i]);
            dfs( temp,nums,remain-1,i+1);
            temp.remove(temp.size()-1);
        }
    }

}