import com.sun.source.tree.Tree;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int leftMost = preorder[0];
        TreeNode tree = new TreeNode(inorder[0]);
        boolean isLeft = true;
        boolean isRight = false;
        TreeNode temp = tree;
        for ( int i =1;i<inorder.length;++i ){

            int val = inorder[i];

            if( val == leftMost){

            }

            if(isLeft){
                tree.left
            }
        }

    }
}