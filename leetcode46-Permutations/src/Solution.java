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
    List<Integer> numsList = new LinkedList<>();
    List<Integer> temp =new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        for(int i:nums){
            numsList.add(i);
        }

        backTrack(nums.length,numsList);

        return answer;
    }

    public void backTrack( int remain,List<Integer> nums){


        if(remain==0){
            answer.add(temp);
            return;
        }

        for( int i=0;i<nums.size();i++){
            temp.add(nums.get(i));
            nums.remove(i);
            backTrack( remain-1,nums);
            temp.remove(temp.size()-1);
        }


    }

}