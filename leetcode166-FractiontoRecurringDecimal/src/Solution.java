import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionToDecimal(1,19));
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
        ArrayList<Integer> repeatRemain = new ArrayList<>();

        double answer = (double) numerator /(double)denominator ;
        int remain;
        double result = (double) numerator /(double)denominator ;
        boolean repeat = false;
        int greaterThanZero = (int)answer;
        int repeatStart = 0;

        // cut the part is greater than 0
        while(answer>10){
            answer = answer % 1;
        }

        // initial the repeatDeci array, put the index 0
        answer=answer*10;
        int firstDeci =(int) answer;
        repeatDeci.add(firstDeci);
        answer = answer %1;

        // initial the remain array, put the index 0
        remain = (int) ((double) numerator % denominator);
        repeatRemain.add(remain);

        // if it reach the end, situation 1, just return the String
        // if it reach another first decimal, put the first part and {( array[] )}
        while(answer!=0){

            // put every decimal properly in to the array
            answer = answer*10;
            int deci =(int) (answer%10);

            // keep check every remainder, if repeated, write the start and {end-1}, that is the repeat part
            remain = remain *10;
            remain = remain % denominator;
            if(!repeatRemain.contains(remain)){
                repeatRemain.add(remain);
                repeatDeci.add(deci);
            }else{
                repeat=true;
                repeatStart = repeatRemain.indexOf(remain);
                break;
            }

            answer = answer %1;
        }

        // return the String according to the 2 situations
        if( repeat){
            String string= greaterThanZero+".";
            for(int j=0;j<repeatStart;++j){
                string+=repeatDeci.get(j);
            }
            string+="(";
            for(int i=repeatStart;i<repeatRemain.size();++i){
                string += repeatDeci.get(i);
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