import java.util.Stack;

class Solution {

    /*
        Invariance:
        1. use stack to store {,(,[
        2. when it reach ),},] pop up one element from stack and compare, if not match, return false
         */

    public boolean isValid(String s) {

        char[] list = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for( int i =0;i<s.length();i++){
            char symbol = list[i];
            if(symbol=='{'||symbol=='['||symbol=='('){
                stack.add(symbol);
            }else{
                if(stack.size()==0){
                    return false;
                }
                char preSymbol = stack.pop();
                if(symbol==')' && preSymbol=='('||symbol=='}' && preSymbol=='{'
                        ||symbol==']' && preSymbol=='['){
                }else{
                    return false;
                }
            }
        }
        // -

        if(stack.size()!=0){
            return false;
        }

        return true;

    }
}

