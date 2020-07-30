import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("au"));
    }
    public int lengthOfLongestSubstring(String s) {
        Set<String> set = new HashSet<>();
        int left =0;
        int right =0;
        int maxLength = 0;
        for(int i=0;i<s.length();++i){
            while(!set.contains(s.substring(right,right+1)) ){
                set.add(s.substring(right,right+1));
                right++;
            }
            left++;
            maxLength=Math.max(maxLength,right-left+1);
        }
        return 0;
    }
}