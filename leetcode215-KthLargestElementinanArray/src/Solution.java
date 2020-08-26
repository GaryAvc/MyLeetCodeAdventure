class Solution {


    int [] num;

    public int findKthLargest(int[] nums, int k) {

        num = nums;

        quickSort(0,nums.length-1);

        return num[nums.length-k];
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

        if(start >= end){
            return;
        }
        int smallerIndex =start-1;
        if( start +1==end){
            if(num[start]>num[end]){
                int temp = num[end];
                num[end] = num[start];
                num[start] = temp;
            }
            return;
        }else{
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
        }

        quickSort(start,smallerIndex-1);
        quickSort(smallerIndex+1,end);



    }
}