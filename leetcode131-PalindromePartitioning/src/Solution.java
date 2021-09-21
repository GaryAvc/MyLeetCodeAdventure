import java.util.LinkedList;
import java.util.List;

class Solution {

    List<String> temp = new LinkedList<>();
    List<List<String>> answer = new LinkedList<>();

    public List<List<String>> partition(String s) {

        char [] list = s.toCharArray();
        bt(list,0);
        return answer;
    }

    public void bt( char[] list, int left){

//        1. at the end, put it in the answer
        if(left == list.length){
            answer.add(new LinkedList<>(temp));
        }

        for( int i=left;i<list.length;i++){
//            2. check if from left -> right is a palindrome or not
            if(!checkPal(list,left,i)){
                continue;
            }

//            make a new string start left to right
            StringBuilder sb = new StringBuilder();
            for( int j = left;j<=i;j++){
                sb.append(list[j]);
            }
            String s = sb.toString();
//            add this string
            temp.add(s);
//            revursive
            bt(list,i+1);
//            delete it
            temp.remove(temp.size()-1);
        }



    }

//    Function to check if this string is a palindrome
    public boolean checkPal(char[] clist, int left, int right){

        while(left<right){

            if(clist[left]!=clist[right]){
                return false;
            }
            left++;
            right--;

        }
        return true;

    }
}