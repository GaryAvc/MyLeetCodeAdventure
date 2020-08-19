import java.util.LinkedList;
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

// iteration SOLUTION
class Solution {

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
        Solution s =  new Solution();
        s.inorderTraversal(x);
    }
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> tree = new LinkedList<>();

        Stack<TreeNode> nodes = new Stack<>();

        while ( root != null || !nodes.empty()){

            while( root != null){

                nodes.push(root);
                root=root.left;

            }

            root = nodes.pop();
            tree.add(root.val);
            root = root.right;

        }

        return tree;
    }
}