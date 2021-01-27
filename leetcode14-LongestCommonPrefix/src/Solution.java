class Solution {
    public String longestCommonPrefix(String[] strs) {

        /*
        invariance:
            1. traverse the first string and traverse the whole array of string
         */

        if(strs.length==0 || strs==null){
            return "";
        }

        int length = strs[0].length();
        String initialString = strs[0];
        for(int i =0;i<length;i++){
            char c = initialString.charAt(i);
            for(int j=0;j<strs.length;j++){
                // the part that i didn't think about, when 2 string goes out of another's bound
                if(i>=strs[j].length()||c!=strs[j].charAt(i)){
                    return initialString.substring(0,i);
                }
            }
        }
        return initialString;

    }
}