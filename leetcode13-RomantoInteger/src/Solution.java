class Solution {


    public int romanToInt(String s) {

        /* Invariance:
            1. the placement should be large -> small
            2. if small symbol come before the large symbol, it should be the case that we do a
            minus
            3. IX equals 10-1 and normally XI equals 10+1
         */

        char[] everyChar = s.toCharArray();
        int preNum = charToInt(everyChar[0]);
        int answer = charToInt(everyChar[0]);

        for(int i=1;i<everyChar.length;i++){
            int thisNum = charToInt(everyChar[i]);
            if(thisNum > preNum){
                answer = answer + thisNum - preNum - preNum;
            }else{
                answer += thisNum;
            }
            preNum = thisNum;
        }

        return answer;

    }

    public int charToInt(char c){

        int value =0;
        switch (c){
            case 'I' :value=1;break;
            case 'V' :value=5;break;
            case 'X' :value=10;break;
            case 'L' :value=50;break;
            case 'C' :value=100;break;
            case 'D' :value=500;break;
            case 'M' :value=1000;break;
            default :value=0;
        }
        return value;
    }

}