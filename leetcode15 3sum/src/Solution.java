import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
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
            if(i>0&&nums[i]==nums[i+1]) {
                continue;
            }
                int l=i+1;
                int r=len-1;
                while (l<r){
                    int sum = nums[i]+nums[l]+nums[r];
                    if(sum==0){
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        ans.add(item);
                        break;
                    }
                    while( l<r && nums[l]==nums[l+1] ){
                        l++;
                    }
                    while(l<r && nums[r]==nums[r-1]  ){
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
        int [] list = {-1,0,1,2,-1,-4};
        Solution s  = new Solution();
        System.out.println(s.threeSum(list));
    }
}