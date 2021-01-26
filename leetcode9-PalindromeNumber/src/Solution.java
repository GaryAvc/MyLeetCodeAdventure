class Solution {

    public boolean isPalindrome(int x) {

        if( x < 0 ){
            return false;
        }else{

            if( x == backNum(x)){
                return true;
            }else{
                return false;
            }
        }


    }

    public int backNum(int x){

        int answer = 0;

        while( x!=0){

            int digit = x%10;
            x=x/10;

            answer = answer *10 + digit;
        }

        return  answer;
    }
}