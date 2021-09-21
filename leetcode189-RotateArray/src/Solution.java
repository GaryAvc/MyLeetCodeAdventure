class Solution {
    public void rotate(int[] nums, int k) {

        if(nums.length ==0 || nums == null){
            return;
        }

        int length = nums.length;

        int [] temp = new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);

        for(int i = 0;i<temp.length;++i){

            int afterIndex = (i+k)%length;
            nums[afterIndex] = temp[i];

        }

    }
}