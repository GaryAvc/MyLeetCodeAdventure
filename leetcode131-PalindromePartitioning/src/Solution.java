import java.util.ArrayList;
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
        // Backtracking
        // Edge case
        if(s == null || s.length() == 0) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }
    public void helper(String s, List<String> step, List<List<String>> result) {
        // Base case
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue; // only do backtracking when current string is palindrome

            step.add(temp);  // choose
            helper(s.substring(i, s.length()), step, result); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }

}