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

        for( int i=0;i<4;i++){
            String thisDigit = remains.substring(0,i+1);
            int thisNum =translate(prev,thisDigit);
            if(  thisNum>255){
                tempAnswer = tempAnswer+ ".";
                backtrack( remain, parts+1, remains,0);
            }else {
                tempAnswer = tempAnswer + thisDigit;
                tempAnswer = tempAnswer+ ".";
                backtrack(remain - 1, parts+1, remains.substring(1, remains.length()), 0);
                tempAnswer = tempAnswer.substring(0,tempAnswer.length()-2);
            }
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