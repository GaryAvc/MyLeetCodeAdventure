import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
    private List<String> list = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs("" , n ,n);
        return list;
    }


    /* Invirance:
    1. only can add right when right being added is < left being added
    which is equal to rightRemain is >= leftRemaining
    which is also equal to if rightRemain < leftRemain, it is wrong , return !
     */
    private void dfs(String s, int leftRemain  , int rightRemain ) {
        if(leftRemain==0 && rightRemain ==0){
            list.add(s);
            return;
        }

        if(rightRemain<leftRemain){
            return;
        }

        if(leftRemain>0){
            dfs(s+"(",leftRemain-1,rightRemain);
        }

        if(rightRemain>0){
            dfs(s+")",leftRemain,rightRemain-1);
        }
    }
}