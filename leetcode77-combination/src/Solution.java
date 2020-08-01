import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.combine(4,3));
    }

    List<List<Integer>> answer = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        int [] nums = new int[n];
        for ( int i=0;i<n;i++){
            nums[i] = i+1;
        }
        dfs(k,nums,0);
        return answer;
    }

    private void dfs ( int remain, int [] nums,int start){

        if( remain ==0){
            answer.add(new LinkedList<>(temp));
            return;
        }

        for( int i=start;i<nums.length;++i){
            int num = nums[i];
            if( temp.contains(num)){
                continue;
            }
            temp.add(num);
            dfs( remain-1,nums,i+1);
            temp.remove(temp.size()-1);
        }

    }
}