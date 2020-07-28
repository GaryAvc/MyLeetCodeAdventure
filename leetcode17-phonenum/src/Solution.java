import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String > answer=new LinkedList<>();
        List<String> letters = changeToLetters(extractNums(digits));
        if(digits.length()==0){
            return answer;
        }else if(digits.length()==1){
            for(String i :letters){
                for(int index=0;index<i.length();index++){
                    answer.add(i.substring(index,index+1));
                }
            }
            return answer;
        }
        answer=letterCombinationsHelper(letters);
        return answer;
    }

    /*
    this function extract all the nums in the String,
    and return the nums as a list
     */
    public List<String> extractNums(String digits){
        List<String> nums = new LinkedList<>();
        for(int i=0;i<digits.length();++i){
            nums.add(digits.substring(i,i+1));
        }
        return nums;
    }

    /*
    this function change the list of nums to list of letters according to its phone
     */
    public List<String> changeToLetters(List<String> nums){
        List<String> letters = new LinkedList<>();
        for(String i:nums){
            switch (i){
                case("2"):letters.add("abc"); break;
                case("3"):letters.add("def");break;
                case("4"):letters.add("ghi");break;
                case("5"):letters.add("jkl");break;
                case("6"):letters.add("mno");break;
                case("7"):letters.add("pqrs");break;
                case("8"):letters.add("tuv");break;
                case("9"):letters.add("wxyz");break;
                default:;
            }
        }
        return letters;
    }

    /*
    this function take 2 string, return the comination of every possible result in list
     */
    public List<String> combineTwoString(String a, String b){
        List<String> combinedTwoString = new LinkedList<>();
        String singleCombined;
        for( int i =0;i<a.length();++i){
            for(int j=0;j<b.length();++j){
                singleCombined = a.substring(i,i+1)+b.substring(j,j+1);
                combinedTwoString.add(singleCombined);
            }
        }
        return combinedTwoString;
    }

    /*
    this function take one string and one list, and combine every single char in string
    and add it in the front of every string in the list
    return the result list
    */
    public List<String> combineStringList(String s, List<String> list) {
        List<String> combinedStringList = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            String thisChar = s.substring(i, i + 1);
            for (String prevString : list) {
                combinedStringList.add(thisChar + prevString);
            }
        }
        return combinedStringList;
    }

    /*
    this function is a helper method for add all the string recursively
     */
    public List<String> letterCombinationsHelper(List<String> restList){
        List<String> answerList;
        if(restList.size()==2){
            return combineTwoString(restList.get(0),restList.get(1));
        }
        String firstString= restList.get(0);
        restList.remove(0);
        answerList= combineStringList(firstString,letterCombinationsHelper(restList));
        return answerList;
    }
}