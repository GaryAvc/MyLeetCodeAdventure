import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int []x ={10,2};
        System.out.println(s.largestNumber(x));
    }
    class combineString implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {
            String str1 = s1+s2;
            String str2 = s2+s1;

            return str2.compareTo(str1);
        }
    }

    public String largestNumber(int[] nums) {
        String [] stringArray = new String[nums.length];
        String answer;
        for(int i =0;i<nums.length;i++ ){
            stringArray[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(stringArray,new combineString());

        if(stringArray[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s:stringArray
             ) {
            sb.append(s);
        }
        return sb.toString();
    }
}