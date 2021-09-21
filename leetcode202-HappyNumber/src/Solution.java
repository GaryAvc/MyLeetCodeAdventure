import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isHappy(19);
    }
    int answer;
    Set<Integer> set;
    public boolean isHappy(int n) {

        set = new HashSet<>();
        helper(n);
        if(answer==1){
            return true;
        }else{
            return false;
        }
    }

    public void helper( int n ){

//        base case
        if(n == 1){
            answer = 1;
            return;
        }else if( !set.add(n) ){
            answer = n;
            return;
        }

        int num=0;

        while(n>0){
            num +=  Math.pow(n%10,2);
            n /=10;
        }

        helper( num);



    }
}