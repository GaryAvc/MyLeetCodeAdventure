class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        /*
        1. 直接COPY一个array，直接在原array上更改
        2. 用了?:句式，进一步简化代码而不用IF ELSE
        3. 用了++，进一步简化代码，不用再特意写P1+=1, P2 += 1
         */


        int [] nums1Copy = new int[nums1.length];

        System.arraycopy( nums1,0,nums1Copy,0,m);

        int p=0;
        int p1=0;
        int p2=0;

        while( (p1<m) && ( p2 <n)){
            nums1[p++]=( nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];
        }

        if( p1 < m){
            System.arraycopy( nums1Copy, p1,nums1 ,p,m-p1);
        }else if ( p2 < n){
            System.arraycopy( nums2, p2, nums1,p,n-p2 );
        }
    }
}