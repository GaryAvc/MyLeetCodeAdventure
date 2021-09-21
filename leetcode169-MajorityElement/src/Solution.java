import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {

        int halflen = nums.length/2;

        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }

        int answercount=0;
        for( Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>halflen){
                answercount = entry.getKey();
                break;
            }
        }
        return answercount;
    }
}