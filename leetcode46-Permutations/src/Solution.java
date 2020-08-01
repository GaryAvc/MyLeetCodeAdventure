import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x = {1,2,3};
        System.out.println(s.permute(x));
    }

    List<List<Integer>> answer = new LinkedList<>();
    List<Integer> temp =new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        backTrack(nums.length,nums);
        return answer;
    }

    public void backTrack( int remain,int[] nums){


        if(remain==0){
            answer.add(new LinkedList<>(temp));
            return;
        }

        for( int i=0;i<nums.length;i++){
            if( temp.contains( nums[i])){
                continue;
            }
            temp.add(nums[i]);
//            nums.remove(i);
            backTrack( remain-1,nums);
            temp.remove(temp.size()-1);
        }


    }

}