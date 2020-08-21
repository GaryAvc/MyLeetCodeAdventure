class Solution {

//    int[]nums;

    public void sortColors(int[] nums) {
//        nums=nums;
        int start = 0;
        int pointer = 0;
        int end = nums.length-1;
        int count =0;
        int temp;

        if( nums.length <2){
            return;
        }

        while( pointer<=end){
            // if the start detect 2, swap it with end, end --, start NOT ++!
            /*
            the reason that when swap 2 with end, pointer NOT ++
            but swap 0 with start, pointer ++, start ++
            is that swap 2 contains one problem that if you swap 2 with 2, you still need to
            swap this 2 to the end of the array
            Since 0, start is at the same place , but 2, start is at different position
             */
            if( nums[pointer] == 2){
                temp=nums[end];
                nums[end] = 2;
                nums[pointer]=temp;
                end--;
            }else if ( nums[pointer]== 0){
                temp=nums[start];
                nums[start] = 0;
                nums[pointer] = temp;
                pointer++;
                start++;
            }else{
                pointer++;
            }
        }

    }




    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x ={2,0,2,1,1,0};
        s.sortColors(x);
    }


//    private void sortColorsHelper ( int start,int end,int one,int ifOne){}
}