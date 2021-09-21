import java.util.HashSet;
import java.util.Set;

class Solution {

    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int maxlength=-1;

        for(int num:nums){

            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+1)){
                    num++;
                    len++;
                }
                maxlength = Math.max(maxlength,len);

            }
        }
        return maxlength;
    }
}