import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] list1 = s.toCharArray();
        char [] list2 = t.toCharArray();

        if(list1.length!=list2.length){
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();

        for( char c : list1){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for( char c:list2){
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<0){
                return false;
            }
        }

        return true;

    }
}