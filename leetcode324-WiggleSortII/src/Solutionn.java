import java.util.Arrays;

class Solution {

    int[]nums;
    public void wiggleSort(int[] nums) {

        this.nums = nums;
        int half = nums.length/2;
        int position = quickSelect(0,nums.length,half);

        int[] num2 = Arrays.copyOf(nums,nums.length);
        int l = 0;
        int r = position+1;
        for(int i = 0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=num2[r];
                r++;
            }else{
                nums[i]=num2[l];
                l++;
            }
        }

    }

    public int partition( int l, int r, int [] nums){

        int num = nums[r-1];

        for(int x = l;x<r;x++){

            if (nums[x] < num) {
                int temp = nums[l];
                nums[l] = nums[x];
                nums[x] = temp;
                l++;
            }
        }

        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        return l;

    }

    public int quickSelect( int l,int r,int k){

        if(0<k &&k<=r){
            int position = partition(l,r,nums);

            if(position == k-1){
                return nums[position];
            }else if (position < k-1){
                return quickSelect(position+1,r,k);
            }else{
                return quickSelect(l,position -1,k);
            }

        }else {
            return Integer.MAX_VALUE;
        }
    }
}