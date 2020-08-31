class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println( s.longestPalindrome("ac"));
    }
    /*
    Invirance:
    1. if the left most and right most is NOT the same -> not palindrome
    2. if left == right, depends on if left+1, right-1 subString is palindrome
    3. when right - left +1 < 2, it is a palindrome
     */
    public String longestPalindrome(String s) {

        if(s.length()<2){
            return s;
        }

        int length = s.length();
        char[] chars =s.toCharArray();

        boolean [][] palindrome = new boolean[length][length];
        int maxLength = -1;
        int maxLeft=-1;
        int maxRight=-1;

        for( int right=1;right<length;right++){
            for(int left=0;left<right;left++){
                if(chars[left]==chars[right]){

                    if( right-left <3){
                        palindrome[left][right]=true;
                    }else{

                        palindrome[left][right]=palindrome[left+1][right-1];;
                    }

                    if(palindrome[left][right]){
                        if( maxLength < right-left){
                            maxLength=right-left;
                            maxLeft=left;
                            maxRight=right;
                        }
                    }

                }else{
                    palindrome[left][right]=false;
                }
            }
        }
        if( maxLeft==-1 || maxRight==-1){
            return s.substring(0,1);
        }
        return s.substring(maxLeft,maxRight+1);
    }
}