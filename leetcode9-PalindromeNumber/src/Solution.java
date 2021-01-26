class Solution {

    public boolean isPalindrome(int x) {

        int initialX= x;

        if( x < 0 ){
            return false;
        }else{

            int answer = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(x);
            int length = sb.toString().length();
            int n = sb.toString().length() / 2;

            while( n!=0){

                int digit = x%10;
                x=x/10;
                n--;

                answer = answer *10 + digit;
            }

            if( x == answer && length %2 ==0){
                return true;
            }else if(x/10 == answer && length%2==1) {
                return true;
            }else{
                return false;
            }
        }


    }


}