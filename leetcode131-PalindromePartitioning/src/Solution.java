import java.util.List;

class Solution {

    char[] letters;

    /*
        Idea:
        1. find the the longest palindrome sub-string from the start index
        2. strip the palindrome sub-string out the 2 outter letters
        3. move the start index right 1, repeat step 1 & 2
     */

    public List<List<String>> partition(String s) {

        letters = s.toCharArray();


    }

}