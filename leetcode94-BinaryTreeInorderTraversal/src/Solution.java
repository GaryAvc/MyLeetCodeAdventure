import java.util.LinkedList;
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

    List<Integer> answer;

    public List<Integer> inorderTraversal(TreeNode root) {

        answer = new LinkedList<>(  );

        dfs(root);

        return  answer;

    }

    private void dfs ( TreeNode node ){
        if(node == null ){
            return ;
        }

        // 1. get the left part
        dfs(node.left);


        // 2. the middle part is already conained in right and left part
        answer.add(node.val);

        // 3. get the riggtriggit[art
        dfs(node.right);

    }

}