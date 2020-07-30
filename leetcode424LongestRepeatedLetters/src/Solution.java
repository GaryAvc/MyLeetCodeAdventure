import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.characterReplacement("ABAB",2);
        System.out.println( s.characterReplacement("ABAB",2));
    }
    public int characterReplacement(String s, int k) {
        char[] eachChar=s.toCharArray();
        int maxLength=-1;
        int left = -1;
        int right = 0;
        int[] charCount = new int[26];
        while( right<k+1){
            charCount[eachChar[right]-'A']++;
            right++;
        }
        while(right<s.length()){
            boolean goExpand=false;
            for(int i=0;i<charCount.length;i++){
                if( charCount[i]>=k){
                    goExpand=true;
                }
            }
            if(goExpand){
                maxLength = Math.max(maxLength,checkMaxLength(left,right,s));
            }
            left++;
            right++;
        }
        return maxLength;
    }

    /*
    this function check the length, 2 pointer expends in 2 directions to check possible
    same chars and re turn max length
     */
    protected int checkMaxLength(int left,int right,String s){
        String targetChar = s.substring(right,right+1);
        while(left!=-1){
            left--;
            if( !s.substring(left,left+1).equals(targetChar)){
                break;
            }
        }
        while(right<s.length()){
            right++;
            if( !s.substring(right,right+1).equals(targetChar)){
                break;
            }
        }
        int maxInterval = right-left-1;
        return maxInterval;
    }

}