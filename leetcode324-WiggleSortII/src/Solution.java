import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,1,2,1,2,2,1};
        s.wiggleSort(nums);
    }
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        int half = nums.length/2;

        Queue<Integer> small = new LinkedList<>();
        Queue<Integer> large = new LinkedList<>();

        for(int i = 0; i <half;i++){
            small.add(nums[i]);
        }

        for(int i = half;i<nums.length;i++){
            large.add(nums[i]);
        }

        int index = 0;
        while( !small.isEmpty() || !large.isEmpty()){
            if(small.isEmpty()){
                nums[index]=large.poll();
            }else if (large.isEmpty()){
                nums[index] = small.poll();
            }else{
                nums[index] = small.poll();
                index++;
                nums[index] = large.poll();
                index++;
            }
        };
    }
}