import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int [] anslist = new int[nums.length];
        Arrays.fill(anslist,1);
        int ans = 1;

        for(int i=0;i<nums.length;++i){

            for(int j = 0;j<=i;++j){

                if(nums[j]<nums[i]){
                    anslist[i] = Math.max(anslist[j]+1,anslist[i]);
                }
            }
            ans = Math.max(ans,anslist[i]);
        }

        return ans;
    }
}