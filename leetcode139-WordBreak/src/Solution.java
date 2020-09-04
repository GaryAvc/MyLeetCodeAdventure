import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    /*
    Invariance:
    1. use a array to store if this index is cutable
    2. the subString of s.substring(j,i) is sutting the first char to the whole String as i grows. push one start letter later as j grows.
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);

        boolean [] correct = new boolean[s.length()+1];
        correct[0]=true;

        for( int i =1;i<=s.length();++i){
            for( int j=0;j<i;j++){

                if( correct[j] && dictionary.contains(s.substring(j,i))){
                    correct[i]=true;
                    break;
                }

            }
        }

        return correct[s.length()];
    }


}