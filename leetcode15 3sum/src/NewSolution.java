import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewSolution {
    public static List<List<Integer>> threeSum(int[] nums) {

        /**
         * invirance
         * 1. sort the array
         * 2. if the first item > 0, quit
         * 3. if the first item = first item +1, duplicate
         * 4. make 2 pointer L,R
         * 5. if nums[L] = nums[L+1], duplicate (same as R)
         * 6. when the sum < 0, L++
         * 7. when the sum >0, R--
         * 8. when Math.abs(L-R) = 1, quit
         * 9. if the nums size is less than 3, return
         */
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums==null){
            return  ans;
        }
        int len = nums.length;
        if(len<3){
            return ans;
        }
        for( int i=0;i<len-2;++i){
            if(nums[i]>0){
                return ans;
            }
            int l=i+1;
            int r=len-1;
            while (Math.abs(l-r)!=0){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[l]);
                    item.add(nums[r]);
                    ans.add(item);
                    break;
                }
                while( nums[l]==nums[l+1] && l+1<=len-2){
                    l++;
                }
                while( nums[r]==nums[r-1] && r-1>=0){
                    r--;
                }
                if(sum<0){
                    l++;
                }else if (sum>0){
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] list = {0,0,0};
        NewSolution s  = new NewSolution();
        System.out.println(s.threeSum(list));
    }
}