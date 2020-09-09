import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionToDecimal(7,-12));
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

        long numerator1 = (long)numerator;
        long denominator1 = (long)denominator;

        ArrayList<Long> repeatDeci = new ArrayList<>();
        ArrayList<Long> repeatRemain = new ArrayList<>();
        String s = "";

        // answer - is the record of the whole nums, remainder - is the every time remainder
        long answer = numerator1 / denominator1;
        answer=Math.abs(answer);
        long remainder = numerator1 % denominator1;

        if( numerator1 * denominator1 >=0){
            // initial the part that is >0 and the .
            s = s+answer +".";
        }else{
            s= s+"-"+answer+".";
        }


        boolean repeat = false;

        int repeatStart = 0;

        // initial the repeatDeci array, put the index 0
        // initial the remain array, put the index 0
        repeatRemain.add(remainder);
        remainder= remainder*10;
        answer = (remainder)/ (denominator1);
        answer = Math.abs(answer);
        remainder =(remainder) % (denominator1);
        remainder = Math.abs(remainder);
        repeatRemain.add(remainder);

        repeatDeci.add(answer);


        // if it reach the end, situation 1, just return the String
        // if it reach another first decimal, put the first part and {( array[] )}
        while(remainder!=0){

            remainder= remainder*10;
            answer = remainder /  Math.abs(denominator1);
            remainder = remainder %  Math.abs(denominator1);

            // put every decimal properly in to the array
            // keep check every remainder, if repeated, write the start and {end-1}, that is the repeat part
            if(!repeatRemain.contains(remainder)){
                repeatRemain.add(remainder);
                repeatDeci.add(answer);
            }else{
                repeat=true;
                repeatStart = repeatRemain.indexOf(remainder);
                repeatDeci.add(answer);
                break;
            }
        }


        // return the String according to the 2 situations
        if( repeat){
            for(int j=0;j<repeatStart;++j){
                s+=repeatDeci.get(j);
            }
            s+="(";
            for(int i=repeatStart;i<repeatDeci.size();++i){
                s += repeatDeci.get(i);
            }
            s = s+")";
            return s;
        }else if( (numerator1/(double)denominator1) % 1 ==0) {
            return ""+numerator1/denominator1;
        }else{
            for(int j=0;j< repeatDeci.size();++j){
                s+=repeatDeci.get(j);
            }
            return s;
        }

    }
}