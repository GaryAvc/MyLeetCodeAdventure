import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        bt(nums.length,nums);
        return answer;
    }

    public void bt (int remains, int [] nums){

        if( remains ==0){
            answer.add(new LinkedList<>(temp));
            return;
        }

        for ( int i=0;i<nums.length;++i){

            if( temp.contains( nums[i])){
                continue;
            }else{
                temp.add(nums[i]);
                bt(remains-1,nums);
                temp.remove(temp.size()-1);
            }
        }


    }
}