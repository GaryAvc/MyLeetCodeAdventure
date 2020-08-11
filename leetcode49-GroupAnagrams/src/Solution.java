import java.util.*;

class Solution {

    List<List<String>> answer;
    Set<Character> duplicate;
    Map< String,List<String>> singleList;

    public List<List<String>> groupAnagrams(String[] strs) {

        duplicate = new HashSet<>();
        singleList = new HashMap<>();

         /*
        this part determine if it is a new anagrams word
         */
        for ( String str : strs){
            char[] eachChar= str.toCharArray();
            Arrays.sort(eachChar);
            String sortedString  = String.valueOf(eachChar);

            if (!singleList.containsKey(sortedString)) {
                List<String> valueList = new LinkedList<>();
                valueList.add(str);
                singleList.put( sortedString, valueList);
            }else{
                singleList.get(sortedString).add(str);
            }
        }

        return answer = new LinkedList<>( singleList.values());
    }
}