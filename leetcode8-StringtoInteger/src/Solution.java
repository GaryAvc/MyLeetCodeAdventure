import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-2147483648"));
        System.out.println(Integer.MAX_VALUE + " "+Integer.MIN_VALUE);
    }
    public int myAtoi(String str) {
        char [] everyChar = str.toCharArray();
        int startIndex = eatWhiteSpace(everyChar);

        if(startIndex==-1){
            return 0;
        }

        char startChar = everyChar[startIndex];
        Stack<Integer> digits;
        int answer;
        if(( startChar-'0'>=0 && startChar-'0'<=9) ){
            digits = convert(everyChar,startIndex);
            answer = makeNum(digits,false);
        }else if(startChar=='+'){
            digits = convert(everyChar,startIndex+1);
            answer = makeNum(digits,false);
        } else if(startChar=='-'){
            digits = convert(everyChar,startIndex+1);
            answer = -(makeNum(digits,true));
        }else{
            return 0;
        }
        return answer;
    }

    /*
    this function take in stack and use it to make a num
     */
    private int makeNum(Stack<Integer> digits,boolean isNegative){
        int digit;
        int answer=0;
        int power=0;
        while (!digits.empty()){
            digit= digits.pop();
            if(answer+digit*Math.pow(10,power)>=Math.pow(2,31)){
                if(isNegative){
                    answer = (int) (Math.pow(2,31))+1;
                }else{
                    answer = (int) (Math.pow(2,31)-1);
                }
                return answer;
            }
            answer += digit*Math.pow(10,power);
            power++;
        }
        return answer;
    }

    /*
    this function convert as many digits as possible into a int
     */
    private Stack<Integer> convert(char[] everyChar, int startNumIndex) {
        int convertedValue = 0;
        Stack<Integer> stack = new Stack<>();
        for( int i=startNumIndex;i<everyChar.length;++i){
            int num = everyChar[i] - '0';
            if( num<0 || num>9 ){
                break;
            }
//            int thisDigit = pickDigit(num);
            stack.push(num);
        }
        return stack;
    }

    /*
    this function eat the white space
     */
    protected int eatWhiteSpace(char [] everyChar){
        for( int i=0;i<everyChar.length;++i){
            if((everyChar[i]-' ')!=0){
                return i;
            }
        }
        return -1;
    }

}