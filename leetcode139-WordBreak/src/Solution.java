import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> x =new LinkedList<>();
        x.add("cats");
        x.add("dog");
        x.add("cat");
        x.add("ski");

        System.out.println(s.wordBreak("catskicatcats",x));
    }

    // this map is a map with key: word's first char in wordDict, value: the char[] of word in dictionary
    Map<Character, List<char[]>> firstLetter;
    boolean answer;
    Set<Character> dictionary;

    public boolean wordBreak(String s, List<String> wordDict) {

        /*
        Invariance:
        1. if string s contain a char that not exist in wordDict, just return false;
         */
        dictionary=new HashSet<>();
        answer = false;
        firstLetter= new HashMap<>();
        for( int i=0;i<wordDict.size();++i){

            char[] word =wordDict.get(i).toCharArray();

            for(int j =0;j<word.length;++j){
                if(!dictionary.contains(word[j])){
                    dictionary.add(word[j]);
                }
            }
            char first = word[0];

            if( firstLetter.containsKey(first)){
                firstLetter.get(first).add(word);
            }else{
                List<char[]> words = new LinkedList<>();
                words.add(word);
                firstLetter.put(first,words );
            }

        }

        char[] targetChar = s.toCharArray();
        for( int i =0;i<targetChar.length;++i){
            if(!dictionary.contains(targetChar[i])){
                return answer;
            }
        }

        helper(s);
        return answer;


    }

    // recurive to solve the prob.
    private void helper(String s){

        //basecase: if s is empty, return true
        if(s.length()==0){
            answer=true;
            return;
        }

        char[] target =s.toCharArray();
        // base case: if the word input, does not contain the first char in the map, it can not be a solution
        if( !firstLetter.containsKey(target[0]) ){
            return;
        }

        List<char[]> words = firstLetter.get(target[0]);

        // iterate the possible dictionary words char[], to see if there exist dictionary words match all char in target char array
        outerLoop:
        for(int i =0;i<words.size();++i){
            char [] word = words.get(i);
            if(target.length<word.length){
                continue;
            }
            for( int j=0;j<word.length;j++){
                if( target[j]!=word[j] ){
                    continue outerLoop;
                }
            }
            helper(s.substring(word.length, target.length));
        }

        return;
    }
}