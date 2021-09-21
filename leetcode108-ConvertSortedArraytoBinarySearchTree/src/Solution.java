import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root =buildt(nums,0,nums.length-1);
        return root;
    }

    public TreeNode buildt(int[] nums,int left, int right){

        if (left > right || left<0 || right<0){
            return null;
        }


        int middle = left + (right - left) /2 ;

        TreeNode root = new TreeNode(nums[middle],buildt(nums,left,middle-1),buildt(nums,middle,right));

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {-10,-3,0,5,9};
        s.sortedArrayToBST(nums);
        int [] n = new int[5];
    }
}


