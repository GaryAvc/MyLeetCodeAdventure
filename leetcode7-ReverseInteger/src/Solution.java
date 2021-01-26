class Solution {

    public int reverse(int x) {

        /*
        Invariance:
            1. if negative - return negative
            2. if the last digit is 0, disgard it
            3. if out of bound - return 0
            4. if 0 - return 0
         */

        int answer = 0;
        int tempX = Math.abs(x);
        if(x==0){
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        // consider the case that the last digit is 0
        int initialDigit = tempX %10;
        tempX=tempX/10;
        if(initialDigit!=0){
            sb.append(initialDigit);
        }

        // keep looping until the number <10
        while( tempX != 0){

            int digit = tempX%10;
            sb.append(digit);
            tempX=tempX/10;

        }

        answer = Integer.parseInt(sb.toString());
        if(x<0){
            answer *=-1;
        }
        return answer;


    }
}