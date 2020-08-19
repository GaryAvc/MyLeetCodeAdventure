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
public class Solution {

    public static void main(String[] args) {
        TreeNode x = new TreeNode(2,new TreeNode(1,null,null),new TreeNode(3,null,null));
        Solution s =new Solution();
        s.isValidBST(x);
    }

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> nodes = new Stack<>();

       TreeNode pre = null;
        while( root != null || !nodes.empty()){

            // this part add all left node in the stack first
            while ( root != null ){
                nodes.add(root);
                root=root.left;
            }

            root =  nodes.pop();

            if( pre!=null && pre.val >= root.val){
                return false;
            }
            pre = root;
            root = root.right;
        }

        return true;
    }

}