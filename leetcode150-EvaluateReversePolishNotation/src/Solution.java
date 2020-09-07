import java.util.Stack;

class Solution {


    /*
    Invariance:
        1. put both nums and operators in a stack
        2. when take in a operator, poll out the top 2 nums and do  second num {operator} first num, and put the result back intu the num stack
        3. when it reach the end of the array, there should only remain one last item in nums and a empty operations. we just need to pop the
            last item in nums and return the answer.
     */

    Stack<String> operations;
    Stack<Integer> nums;

    public int evalRPN(String[] tokens) {

        operations = new Stack<>();
        nums = new Stack<>();
        int answer=Integer.MIN_VALUE;

        if(tokens.length==1){
            answer =Integer.parseInt( tokens[0]);
        }

        for( int i=0;i<tokens.length;++i){
            if(isInt(tokens[i])){
                nums.add(Integer.parseInt(tokens[i]));
            }else{
                operations.add(tokens[i]);

                // calculate as Invariance 2. said
                // get top 2 nums
                int first = nums.pop();
                int second = nums.pop();
                int result;

                // get the operation for the 2 nums
                String opt = operations.pop();
                switch (opt){
                    case "+":result=second+ first;break;
                    case "-": result=second- first;break;
                    case "*": result=second* first;break;
                    case "/": result=second/ first;break;
                    default: result = Integer.MAX_VALUE;
                }

                // add the new result back into the num stack
                nums.add(result);

                // base case:
                if(i== tokens.length-1){
                    answer = nums.pop();
                }
            }
        }

        return answer;
    }

    // this function take in a String and return boolean if it is a num
    private boolean isInt(String token) {
        boolean isAint=true;
        try{
            Integer.parseInt(token);
        }catch (NumberFormatException x){
            isAint=false;
        }
        return isAint;
    }
}