/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n-1;


        while( left + 1 < right ){

            int mid = (left + right)/2;
            if( isBadVersion(mid) ){
                right = mid;
            }else{
                left = mid;
            }
        }

        if(isBadVersion(left)){
            return left;
        }
        if(isBadVersion(right)){
            return right;
        }
        return -1;
    }
}