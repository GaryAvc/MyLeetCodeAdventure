class Solution {

    /*
    Constrain:
        1. no Division
        2. O(n)
        3. constant space
     */

    /*
    Invariance:
        1. loop 2 time for the whole loop, from left to right and from right to left
        2. the 2 array store the product of current all nums
        3. when it reach i item, just multiple L[i-1] with R[i+1]
     */
    public int[] productExceptSelf(int[] nums) {

        int[]left=new int[nums.length];
        int[]right=new int[nums.length];
        int[]answer = new int[nums.length];

        for(int i =0;i<nums.length;i++){
            if( i==0){
                left[i]=nums[i];
                right[nums.length-1]=nums[nums.length-1];
            }else{
                left[i]=left[i-1] *nums[i];
                right[nums.length-1-i]=right[nums.length-1-i+1] *nums[nums.length-1-i];
            }
        }

        for( int i=0;i<nums.length;++i){
            if(i==0){
                answer[i]=right[i+1];
            }else if(i==nums.length-1){
                answer [i] = left[i-1];
            }else {
                answer[i] = left[i-1] *right[i+1];
            }
        }

        return answer;
    }
}