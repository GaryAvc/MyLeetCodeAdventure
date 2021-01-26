import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public String countAndSay(int n) {

        // base case :
        if (n==1){
            return "1";
        }

        // previous string:
        String bef = countAndSay(n-1);

        // turn it into an array
        char[] list = bef.toCharArray();

        // generate new string
        StringBuilder sb = new StringBuilder();

        // initial the count of each number to 1
        int count =1;

        // go through the list to generate the new string
        for(int i =0;i<list.length;i++){
            // base case: when it is different with the next digit
            if(i ==list.length-1|| list[i] != list[i+1] ){
                sb.append(count);
                sb.append(list[i]);

                // reset the value of count
                count =1;
            }else{
                count++;
            }
        }

        return sb.toString();
    }


}