class Solution {


    public int reverse(int x) {

        long temp=0;
        int answer = 0;

        while(x!=0){
            int digit = x %10;
            x=x/10;
            temp = temp *10 + digit;
        }

        if(temp > Integer.MAX_VALUE || temp <Integer.MIN_VALUE){
            return 0;
        }else{
            answer = (int)temp;
        }

        return answer;
    }
}