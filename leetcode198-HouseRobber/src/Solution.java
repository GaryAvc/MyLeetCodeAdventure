class Solution {
    public int rob(int[] nums) {

//        int odd = 0;
//        int even = 0;
//
//        for( int i=0;i<nums.length;++i){
//
//            if((i+1)%2==0){
//                even+=nums[i];
//            }else{
//                odd+=nums[i];
//            }
//        }
//
//        return Math.max(even,odd);
//        ----- first try ------

        list = new int [nums.length];
        for(int i =0;i<list.length;i++){
            list[i]=-1;
        }
        return helper(nums.length-1,nums);

    }

    int [] list;

    public int helper(int index,int[]nums){

        if(index==0){
            return nums[0];
        }else if(index ==1){
            return Math.max(nums[0],nums[1]);
        }else{
            if(list[index-2]==-1){
                list[index-2]=0;
                list[index-2] =helper(index-2,nums);
            }
            if(list[index-1]==-1){
                list[index-1]=0;
                list[index-1] =helper(index-1,nums);
            }

            return Math.max(nums[index] + list[index-2],list[index-1]);

        }
    }
}