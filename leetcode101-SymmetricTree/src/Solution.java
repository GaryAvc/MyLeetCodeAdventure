import java.util.ArrayList;

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

    ArrayList list = new ArrayList();
    public boolean isSymmetric(TreeNode root) {



        inorder(root);

        for( int i =0;i<list.size();i++){
            if( list.get(i) != list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root){

        if( root ==null){
            list.add(-1);
            return;
        }
        if((root.left== null && root.right!=null)){
            list.add(-1);
        }
        inorder(root.left);
        list.add(root.val);
        if((root.right == null && root.left!=null) ){
            if(root.right == null) {
                list.add(-1);
            }
        }
        inorder(root.right);

    }
}