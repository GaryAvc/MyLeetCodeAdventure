class Solution {

    public String longestCommonPrefix(String[] strs) {

        String answer= "";
        int answerIndex = 0;

        if(strs.length<1){
            return "";
        }else if ( strs.length==1){
            return strs[0];
        }

        for(int i =0;i<strs[0].length();i++){
            if(!compareEachChar( strs, i)){
                answerIndex = i-1;
                break;
            }
        }

        if(answerIndex!=0){
            answer = strs[0].substring(0,answerIndex+1);
        }

        return answer;
    }

    public boolean compareEachChar(String[] strs, int index){
        char initialChar = strs[0].charAt(index);
        for (String s: strs
             ) {
            if( index >= s.length() || initialChar!= s.charAt(index)){
                return false;
            }
        }
        return true;
    }

}