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
        if(s.equals("")){
            return 0;
        }
        Map<Integer,String> map = new HashMap<>();
        for( int i=0;i<s.length();++i){
            map.put(i,s.substring(i,i+1));
        }
        int left =0;
        int right =0;
        int maxsize =1;
        Set<String> set = new HashSet<>();
        set.add(map.get(left));
        for(int i=0;i<s.length()-1;++i){
            right++;
            left=checkDupAndMoveL(set,left,map.get(right),map);
            set.add(map.get(right));
            if(maxsize<right-left+1){
                maxsize=right-left+1;
            }
        }
        return maxsize;
    }

    /*
    this function use set to check if there is any duplicate when new item added in
    if duplicated, move the left pointer right by 1
     */
    public int checkDupAndMoveL (Set<String> set, int left, String newItem,
                                 Map<Integer,String> map){
        while(set.contains(newItem)){
                set.remove(map.get(left));
                left++;
        }
        return left;


    }
}