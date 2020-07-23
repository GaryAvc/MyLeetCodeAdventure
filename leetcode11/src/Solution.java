class Solution {
    int maxsize =0;
    public int maxArea(int[] height) {
        int length =height.length;

        while(length>2){
            height=baseCase(height);
            length =height.length;

        }
        if( length==2 &&Math.min(height[0],height[1])>maxsize){
            return Math.min(height[0],height[1]);
        }
        return maxsize;
    }

    /**
     * invirance:
     * 1. start from the greatest width
     * 2. base case: short:a long:b change the shorter one to the nearest but longer than b,
     *      then compare the size with original one
     * 3. repeat for the rest of the array
     */

    /*
        to do the base case operation
     */
    public int[] baseCase(int[] height){
        int shorterHeight = Math.min(height[0],height[height.length-1]);
        int longerHeight = Math.max(height[0],height[height.length-1]);
        int originalSize =shorterHeight * (height.length-1);
        if(maxsize<originalSize){
            maxsize=originalSize;
        }
        int[] newarray = new int[0];

        if(shorterHeight==height[0]){
                    newarray = copyArray(height,1,height.length-1);
        }else{
                    newarray = copyArray(height,0,height.length-2);
        }
        return newarray;
    }

    /*
        copy the array into new array;
     */
    public int[] copyArray(int [] originalArray,int start,int end){
        int[] newArray = new int[end-start+1];
        for ( int i=0;i<end-start+1;++i){
            newArray[i]=originalArray[start+i];
        }
        return newArray;
    }
}