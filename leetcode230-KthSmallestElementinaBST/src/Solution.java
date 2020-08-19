import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> nodes = new Stack<>();

        while( root != null || !nodes.empty()){

            while( root != null){
                nodes.add(root);
                root=root.left;
            }

            root = nodes.pop();
            k--;
            if( k == 0 ){
                return root.val;
            }
            root=root.right;
        }
        return Integer.MIN_VALUE;
    }
}