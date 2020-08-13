class Solution {
    public double myPow(double x, int n) {

        return n<0 ? 1.0 / mypowHelper(x,-n) : mypowHelper(x,n);
    }

    private double mypowHelper( double x,int n){
        if( n == 0){
            return 1;
        }
        double y = mypowHelper(x,n/2);
        return (n %2==0)?y*y:x*y*y;
    }
}