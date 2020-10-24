class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        s.numSquares(13);
    }


    public int numSquares(int n) {

        int[] list = new int[n+1];

        // initial the every item
        for(int i =1;i<n+1;i++){
            list[i]=i;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;i-j*j>=0;j++){
                list[i] = Math.min( list[i], list[i-j*j]+1);
            }
        }

        return list[n];
    }
}