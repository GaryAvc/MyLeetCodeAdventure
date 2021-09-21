import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {

        Set set = new HashSet();

        for(int i =0;i<nums.length;i++){

            if(!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }

        int x = (int)set.toArray()[0];
        return x;
    }
}