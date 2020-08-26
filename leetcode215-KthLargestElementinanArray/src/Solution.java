class Solution {

    int [] num;
    int target;
    int answer;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = {2,1};
        int k=1;
        s.findKthLargest(x,k);
    }

    public int findKthLargest(int[] nums, int k) {

        num = nums;
        target = nums.length-k;
        answer=Integer.MIN_VALUE;

        if( nums.length==1){
            return nums[0];
        }
        quickSort(0,nums.length-1);
        return answer;
    }

    /*
    Steps:
    1. choose the last item
    2. one for loop
    3. index i start 0 to length -1
    4. smaller index start from -1
    5. when it detect a value < requirement , smallIndex++ , swap i with smallIndex

    Recursion to do the left part and right part
     */
    private void quickSort(int start,int end) {



        if(!(start<end)){
            if( start == end &&start == target){
                answer =  num[target];
            }
            return ;
        }

        int smallerIndex =start-1;

        // quickSort once
        int targetValue = num[end];

        for( int  i=start;i<=end;++i){
            if(num[i] <= targetValue || i==end){
                smallerIndex++;
                if( smallerIndex!= i){
                    int temp = num[i];
                    num[i] = num[smallerIndex];
                    num[smallerIndex] = temp;
                }
            }
        }

        if( smallerIndex == target){
            answer =  num[target];
        }

        if( smallerIndex < target ){
            quickSort(smallerIndex+1,end);
        }else if(smallerIndex > target ){
            quickSort(start,smallerIndex-1);
        }

    }
}