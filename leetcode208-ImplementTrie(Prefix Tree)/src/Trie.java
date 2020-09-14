import java.util.HashMap;
import java.util.Map;

/*
Invariance:
    1. the basic idea of this tree is that one Trie contain a map, a char, and a boolean
    2. the map, use key - {the Value of the char}, the value - {the next Trie}
    3. the value of the char is the current characterm, the boolean is true when it contains this word
 */

class TrieNode{
    Map<Character,TrieNode> map;
    boolean end;
    char currentLetter;

    /** Initialize your data structure here. */
    public TrieNode() {
        map = new HashMap<>();
        end = false;
        currentLetter =' ';
    }

    /** Initialize your data structure here. */
    public TrieNode(char letter,boolean isTheEnd) {
        map = new HashMap<>();
        end = isTheEnd;
        currentLetter=letter;
    }
}

class Trie {

    public static void main(String[] args) {
//        ["Trie","insert","search","search","startsWith","insert","search"]
//        [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
        Trie root = new Trie();
        root.insert("app");
        root.insert("apple");
        root.insert("beer");
        root.insert("jam");
        root.search("rental");
        root.search("apps");
        root.search("app");
        root.startsWith("app");
        root.insert("app");
        root.search("app");

    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Initialize your data structure here. */
    public Trie(char letter,boolean isTheEnd) {
        root = new TrieNode(letter,isTheEnd);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        char[] letters = word.toCharArray();
        TrieNode temp = root;

        // check if root contains the first word
        for(int i =0;i<letters.length;++i){

            // when it is the end, make the end to TRUE
            boolean isEnd = false;
            if(i==letters.length-1){
                isEnd=true;
            }

            char tempChar = letters[i];
            if(temp.map.containsKey(tempChar)){
                temp = temp.map.get(tempChar);
                if(i==letters.length-1){
                    temp.end = true;
                }
                continue;
            }else{
                TrieNode newLetter = new TrieNode(tempChar,isEnd);
                temp.map.put(tempChar,newLetter);
                temp = newLetter;
            }
        }



    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        char[] letters = word.toCharArray();
        TrieNode temp = root;

        if(temp.map.containsKey(letters[0])){
            temp = temp.map.get(letters[0]);
        }else{
            return  false;
        }

        // 1. if can NOT find the letter break and return false,
        // 2. if it reach the end but the value of END is false
        for(int i =1;i<letters.length+1;++i){

            if(i==letters.length){
                // when it reach the end, return whatever is in the value
                return temp.end;
            }

            char tempChar = letters[i];
            if(temp.map.containsKey(tempChar)){
                temp = temp.map.get(tempChar);
                continue;
            }else{ // do NOT contain the char that is seeking for, return false
                return false;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        TrieNode temp = root;

        if(temp.map.containsKey(letters[0])){
            temp = temp.map.get(letters[0]);
        }else{
            return  false;
        }

        // 1. if can NOT find the letter break and return false,
        // 2. if it reach the end but the value of END is false
        for(int i =1;i<letters.length+1;++i){

            if(i==letters.length){
                // when it reach the end, return whatever is in the value
                return true;
            }

            char tempChar = letters[i];
            if(temp.map.containsKey(tempChar)){
                temp = temp.map.get(tempChar);
                continue;
            }else{ // do NOT contain the char that is seeking for, return false
                return false;
            }
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */