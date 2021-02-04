class Solution {

    /*
    Invariance:
    1. Basice idea: binary search
    2. when the middle point sqr < x . and middle +1 sqr > x, success!
        otherwise, use recursionly call the binary search
     */
    int target;

    public int mySqrt(int x) {

        target = x;
        if(x==1 || x ==0){
            return x;
        }

        return bs(0,x);
    }

    public int bs(int left, int right){

        int middle = (left+right)/2;
        long middleSqr =(long) (middle) *(long)(middle);
        long middleNextSqr = (long)(middle+1) *(long)(middle +1);

        // base case :
        if(middleSqr <=target && middleNextSqr > target){
            return middle;
        }else if( middleSqr > target){
            return bs(left,middle);
        }else {
            return bs(middle,right);
        }

    }


}