import java.util.ArrayDeque;
import java.util.Queue;

/*
Invariance:
    1. it always start with a num and end with a num
    2. Turn a string into value int, just reach the first operator and
        add what is before into a string builder, and to String, and parseInt
    3. if the oepration is + or -, put the num before it into a stack and put the operator in
    4. if the operator is * or /, we pop the operator and 2 nums, calculate and push the result
    5. there should be 3 queue, one for all the final + and -, one for temp nums, one for temp operator
        (size 2)
    6. when it reach size of 2, if operator is +/-, pop each one from num and operator into final queue
        if * or /, pop 2 from temp num and pop 1 from operator, calculate push result into temp num
    7. if it reach the end of the Stirng but no operator, parse the final part as a num
    8. if temp Operator is empty, pop the last num into the final queue
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println( s.calculate("1+1+1"));
    }

    Queue<Integer> tempNum;
    Queue<String>   tempOperator;
    Queue<String> finalOperator;
    Queue<Integer> finalNum;
    StringBuilder sb;

    public int calculate(String s) {
        tempNum = new ArrayDeque<>();
        tempOperator = new ArrayDeque<>();
        finalOperator = new ArrayDeque<>();
        finalNum = new ArrayDeque<>();
        sb=new StringBuilder();

        int answer=0;


        char[] letters = s.toCharArray();
        // loop through every letter of the string and parse one num and one operator everytime
        for( int i =0;i<letters.length;i++){


            if(letters[i]=='*'||letters[i]=='/'||letters[i]=='+'||letters[i]=='-' || i == letters.length-1){
                // add the last num
                if(i==letters.length-1&&letters[letters.length-1]!=' '){
                    sb.append(letters[letters.length-1]);
                }
                // parse the int before the operator
                String numS = sb.toString();
                int num= Integer.parseInt(numS);
                sb=new StringBuilder();


                // push this pair of num and operator into the temp queue
                tempNum.add(num);
                if(i!= letters.length) {
                    // parse this operator
                    String operator = Character.toString(letters[i]);
                    tempOperator.add(operator);
                }

                // if the size of the tempOperator reach 2, pop one pair of operator and num
                if(tempNum.size()==2){
                    String operatorTemp = tempOperator.poll();
                    if(operatorTemp.equals("*")||operatorTemp.equals("/")){
                        int num1 = tempNum.poll();
                        int num2 = tempNum.poll();
                        int newNum;
                        if(operatorTemp.equals("*")){
                            newNum= num1 * num2;
                        }else{
                            newNum = num1 / num2;
                        }
                        tempNum.add(newNum);
                    }
                    // add the operator and one num into final
                    if(operatorTemp.equals("+")||operatorTemp.equals("-")){
                        int numTemp = tempNum.poll();
                        finalNum.add(numTemp);
                        finalOperator.add(operatorTemp);
                    }
                }

                if(i == letters.length-1){
                    finalNum.add(tempNum.poll());
                }
            }else if(letters[i]!=' '){
                sb.append(letters[i]);
            }
        }

        // initial the answer
        answer = finalNum.poll();
        // now add up the final +/- queue to the answer
        int size = finalOperator.size();
        for (int i =0;i< size;i++){
            String operator = finalOperator.poll();
            int num = finalNum.poll();
            if(operator.equals("+")){
                answer+=num;
            }else{
                answer-=num;
            }
        }
        return answer;
    }
}