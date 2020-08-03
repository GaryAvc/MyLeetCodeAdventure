import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.restoreIpAddresses("25525511135");
        System.out.println(s.restoreIpAddresses("25525511135"));
    }

    List<String> answer;
    String tempAnswer;


    public List<String> restoreIpAddresses(String s) {

        answer = new LinkedList<>();
        tempAnswer="";
        backtrack( s.length(),0,s,0);
        return answer;
    }

    public void backtrack ( int remain, int parts, String remains, int prev){

        if( parts>4){
            return;
        }

        if( remain == 0){
            answer.add(new String(tempAnswer));
            return;
        }

        String thisDigit = remains.substring(0,1);
        int thisNum =translate(prev,thisDigit);
        if(  thisNum>255){
            tempAnswer = tempAnswer+ ".";
            backtrack( remain, parts+1, remains,0);
            return;
        }else {
            tempAnswer = tempAnswer + thisDigit;
            backtrack(remain - 1, parts, remains.substring(1, remains.length()), thisNum);
            return;
        }

//        tempAnswer = tempAnswer + thisDigit;
//        backtrack(remain - 1, parts, remains.substring(1, remains.length()), thisNum);
//        return;
    }

    /*
    this function take previous num and new num(in String) to return a int value of new created num
     */

    public int translate( int prev, String now ){

        int newInt = prev*10 +  Integer.parseInt(now);
        return newInt;
    }

}