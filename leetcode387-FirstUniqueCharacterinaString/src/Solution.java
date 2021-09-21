import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {

        char [] list = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        for( char c: list){

            map.put(c,map.getOrDefault(c,0)+1);

        }
        int index = 0;
        for(char c:list){
            if( map.get(c)==1){
                return index;
            }
            index++;
        }
        return -1;
    }
}