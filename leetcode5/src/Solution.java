class Solution {
    public String longestPalindrome(String s) {
        String[] list = new String[s.length()];
        int maxLen =0;
        int maxIndex = 0;
        for( int i =0;i<s.length();++i){
            list[i]=s.substring(i,i+1);
        }
        for( int i =1;i<s.length()-1;++i){
            int testLen=0;
            boolean threediffernt = true;
            boolean firstEqual = s.substring(i,i+1).equals(s.substring(i-1,i));
            boolean nextEqual = s.substring(i,i+1).equals(s.substring(i+1,i+2));
            if(firstEqual  &&nextEqual){
                threediffernt=false;
            }
            if((firstEqual||nextEqual)&&threediffernt){
                testLen = maxlength(list,i,i+1) +2;
            }else{
                testLen = maxlength(list,i,i)+1;
            }

            if( maxLen<testLen){
                maxLen= testLen;
                maxIndex = i;
            }
        }

        if(s.length()==0){
            return s;
        }
        else if(s.length()==1){
            return s;
        }
        else if ( s.length()==2&&list[0].equals(list[1])){
            return s;
        }
        else if ( maxLen==0){
            return list[0];
        }else if(maxLen%2==0 && maxLen==2 && list[maxIndex].equals(list[maxIndex+1])) {
            return s.substring(maxIndex - maxLen / 2 + 1, maxIndex + 2);
        }else if(maxLen%2==0 && maxLen==2 && list[maxIndex].equals(list[maxIndex-1])) {
            return s.substring(maxIndex-1,maxIndex+1);
        }
        else if(maxLen%2==0){
            return s.substring(maxIndex-maxLen/2+1,maxIndex+maxLen/2+1);
        }else{
            return s.substring(maxIndex-maxLen/2,maxIndex+maxLen/2+1);
        }

    }

    //     return the max length (not counting the base) direction of the palindromic substring
    public int maxlength( String[] list,int index,int indexplus){
        int maxoneside = 0;
        int left = index-1;
        int right = indexplus +1;

        while( left>=0&&right<list.length){
            if(list[left].equals(list[right])){
                maxoneside+=2;
            }
            left--;
            right++;
        }

        return maxoneside;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("aaaa"));
    }
}