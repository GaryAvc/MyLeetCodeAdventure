import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionToDecimal(1,2));
    }
    /*
    Invariance:
        1. I now just take it naively that the repeat part is the next time the first dicimal appear
        2. we put the repeated part into the ()
        3. only 2 situations, 1. fully divided 2. can NOT be fully divided
        4. we take a loop from the start of the first dicimal to the end,
            if there is no first dicimal, it is situation 1
            if there is a first dicimal, it is situation 2
     */
    public String fractionToDecimal(int numerator, int denominator) {

        ArrayList<Integer> repeatDeci = new ArrayList<>();
        double answer = (double) numerator /denominator ;
        double result = (double) numerator /denominator ;
        boolean repeat = false;
        int greaterThanZero = (int)answer;

        // cut the part is greater than 0
        while(answer>10){
            answer = answer % 1;
        }

        answer=answer*10;
        int firstDeci =(int) answer;
        repeatDeci.add(firstDeci);
        answer = answer %1;

        // if it reach the end, situation 1, just return the String
        // if it reach another first decimal, put the first part and {( array[] )}
        while(answer!=0){
            answer = answer*10;
            int deci =(int) (answer%10);
            if( deci!=repeatDeci.get(0)){
                repeatDeci.add(deci);
            }else{
                repeat = true;
                break;
            }
            answer = answer %1;
        }

        // return the String according to the 2 situations
        if( repeat){
            String string= greaterThanZero+".(";
            for(int i:repeatDeci){
                string += i;
            }
            string = string+")";
            return string;
        }else if( result % 1 ==0) {
            return ""+(int)result;
        }else{
            return ""+result;
        }

    }
}