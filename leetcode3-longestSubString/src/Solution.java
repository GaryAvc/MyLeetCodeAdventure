import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxlength =0;
        Map<Integer,String> map = store(s);
        for( int i=0;i<s.length();++i){
           if(maxlength<interval(map,i) && !checkDuplicate(map,i,interval(map,i))){
               maxlength=interval(map,i);
           }
        }
        return maxlength;
    }

    /*
    it store the every character in string into a hashmap
     */
    public Map<Integer,String> store(String s){
        Map<Integer,String> everyChar = new HashMap<>();
        for(int i=0;i<s.length();++i){
            everyChar.put(i,s.substring(i,i+1));
        }
        return everyChar;
    }

    /*
    this function check the distance between nearest same character
     */
    public int interval (Map<Integer,String> map, int index){
        String origin = map.get(index);
        for ( int i=index+1;i<map.size();++i){
            if (origin.equals(map.get(i))){
                return i-index+1;
            }
        }
        return map.size()-index;
    }

    /*
    this function check in this range does it contain any duplicated items
     */
    public boolean checkDuplicate(Map<Integer,String> map, int index,int length ){
        Set<String> checkDuplicate = new HashSet<>();
        for (int i=0;i<length-1;++i){
            if( !checkDuplicate.contains(map.get(i+index))){
                checkDuplicate.add(map.get(i+index));
            }else{
                return true;
            }
        }
        return false;
    }

}

