import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if( root == null){
            return new LinkedList<List<Integer>>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> outer = new LinkedList<>();


        while( !queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new LinkedList<>();

            for ( int i =0;i<size;++i){
                TreeNode node = queue.poll();
                inner.add(node.val);
                if( node.left!=null){
                    queue.add(node.left);
                }
                if( node.right!=null){
                    queue.add(node.right);
                }
            }
            outer.add(inner);
        }

        return outer;
    }
}