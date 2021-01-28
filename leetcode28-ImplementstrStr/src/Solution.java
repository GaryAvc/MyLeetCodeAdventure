class Solution {


    public int strStr(String haystack, String needle) {

        if( needle.length()==0){
            return 0;
        }

        if(haystack.length()==0 ){
            return -1;
        }


        char[] str = haystack.toCharArray();
        char[] need = needle.toCharArray();

        char initialNeedle = need[0];

        int answer = -1;

        for(int left =0;left<str.length;left++){
            char temp = str[left];
            boolean correct = true;
            if(temp == initialNeedle){
                for(int right = 0;right<needle.length();right++){
                    if( left+right>=str.length|| need[right]!=str[left+right]){
                        correct=false;
                        break;
                    }
                }
                if(correct) {
                    return left;
                }
            }
        }
        return answer;

    }


}