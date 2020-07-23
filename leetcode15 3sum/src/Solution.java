import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threesum = new ArrayList<>();
        for( int num0=0;num0<nums.length-2;++num0){
            List<Integer> returnTwoList = sumOfTwo(nums,num0+1,-nums[num0]);
            if(returnTwoList!=null){
                for(int i=0;i<returnTwoList.size()/2;++i){
                    List<Integer> oneThreeSum = new ArrayList<>();
                    oneThreeSum.add(nums[num0]);
                    oneThreeSum.add(returnTwoList.get(2*i));
                    oneThreeSum.add(returnTwoList.get(2*i+1));
                    checkDuplicateAndAdd(threesum,oneThreeSum);
                }
            }
        }
        return threesum;
    }

    private void checkDuplicateAndAdd(List<List<Integer>> threesum,List<Integer> oneThreeSum ) {
        oneThreeSum.sort(Comparator.naturalOrder());
        if(threesum.size()==0){
            threesum.add(oneThreeSum);
        }else{
            boolean isUnique=true;
            for(List<Integer> item : threesum){
                item.sort(Comparator.naturalOrder());
                if(item.equals(oneThreeSum)){
                   isUnique=false;
                }
            }
            if(isUnique){
                threesum.add(oneThreeSum);
            }
        }

    }

    public List<Integer> sumOfTwo(int[] nums,int start, int sum) {
        List<Integer> two = new ArrayList<>();
        for (int num1 = start; num1 < nums.length; ++num1) {
            for (int num2 = num1 + 1; num2 < nums.length; ++num2) {
                if (nums[num1] + nums[num2] == sum) {
                    two.add(nums[num1]);
                    two.add(nums[num2]);
                }
            }
        }
        return two;
    }

//    public static void main(String[] args) {
//        Solution s= new Solution();
//        int [] list ={-1, 0, 1, 2, -1, -4};
//        System.out.println(s.threeSum(list));
//    }
}
