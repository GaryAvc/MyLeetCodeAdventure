import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : nums1){

            map.put(num, map.getOrDefault(num,0)+1);

        }

        for(int num:nums2){

            if(map.get(num)!=null && map.get(num)>0){
                list.add(num);
                map.put(num,map.get(num)-1);
            }
        }

        int [] answer = new int[list.size()];
        int i =0;
        for(int x: list){
            answer[i] = x;
            i++;
        }
        return answer;
    }
}