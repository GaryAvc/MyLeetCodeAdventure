class Solution {
    public int findDuplicate(int[] nums) {

        int length = nums.length;
        int index=-1;

        out : for(int i =0;i<length;i++){
            for(int j =i+1;j<length;j++){
                if(nums[i]==nums[j]){
                    index=i;
                    break out;
                }
            }
        }

        return nums[index];
    }
}