

import java.util.*;


class Solution {

    public static void main(String[] args) {
        int [] x ={0,0};
        Solution s = new Solution();
        s.largestNumber(x);
    }

    /*
    Invariance:
        1. first, loop the nums array to get the longest num, Then, loop again, extend every num to be this long by adding the origin digits
        2. if the same part is the last digit, continuously, use the same part as the different part for comparation until one digit is different
            {e.g 3456 - 34563459 'same-3456' keep compare '34563456 - 34563459' we see that 34563459 is larger}
        3. use a Hashmap to store the relationship between the new value and original index { key - new int value, value - origin index []}
            (1) if the size of  index[] is greater than 1, then add index[0] value {size()} times into the String, since we dont care which one
                we are adding
     */
    public String largestNumber(int[] nums) {

        String answer = "";
        Set<Integer> usedIndex = new HashSet<>();
        Arrays.sort(nums);
        int maxLength = ((Integer)nums[0]).toString().length();
        long [] newNums = new long[nums.length];
        Map<Long,List<Integer>> map = new HashMap<>();

        // loop the nums array & extend the nums
        for(int i =0;i<nums.length;i++){
            int tempNum = nums[i];

            // extends the num using its existing digit
            String originDigits =((Integer) tempNum).toString();
            int length = originDigits.length();
            int times = maxLength/length;
            int remain = maxLength%length;
            String extend = "";
            for( int j =0;j<times;j++){
                extend+=originDigits;
            }
            extend+=originDigits.substring(0,remain+1);
            Long newNum =Long.parseLong(extend);

            // put it in new array
            newNums[i]=newNum;

            // set the relationship in the map
            if( map.containsKey(newNum)){
                map.get(newNum).add(i);
            }else{
                List<Integer> indexArray = new LinkedList<>();
                indexArray.add(i);
                map.put(newNum,indexArray);
            }

        }

        // sort the new array (which in here the nums are sort)
        Arrays.sort(newNums);

        // use the sorted value to get original index, then use the index to put the original int into the answer String
        for( int i =newNums.length-1;i>=0;i--){
            Long newValue = newNums[i];
            List<Integer> list = map.get(newValue);


            // if the size of the returning list is > 1, then add {size()} times into the answer string
            for( int j=0;j<list.size();j++){
                // every index to original list in here
                int index =list.get(j);
                if( usedIndex.contains(index)){
                    continue;
                }else{
                    int originalVal = nums[index];
                    answer+=((Integer)originalVal).toString();
                    usedIndex.add(index);
                }

            }
        }

        return answer;
    }
}