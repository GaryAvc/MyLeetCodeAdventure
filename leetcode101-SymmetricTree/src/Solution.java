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

    // --- iteratively ---



    // -- end of iteratively --

//    // ---- recursion ----
//    public boolean isSymmetric(TreeNode root) {
//
//        TreeNode l = root.left;
//        TreeNode r = root.right;
//
//        return check(l,r);
//
//    }
//
//    public boolean check( TreeNode l, TreeNode r){
//
//        if(l==null && r==null){
//            return true;
//        }else if(l==null || r==null){
//            return false;
//        }else{
//            return (l.val==r.val) && check(l.left,r.right) &&check(l.right,r.left);
//        }
//    }
//
//    // ---- end of recursion ----


//    ArrayList list = new ArrayList();
//    public boolean isSymmetric(TreeNode root) {
//
//
//
//        inorder(root);
//
//        for( int i =0;i<list.size();i++){
//            if( list.get(i) != list.get(list.size()-1-i)){
//                return false;
//            }
//        }
//        return true;
//    }

//    public void inorder(TreeNode root){
//
//        if( root ==null){
//            list.add(-1);
//            return;
//        }
//        if((root.left== null && root.right!=null)){
//            list.add(-1);
//        }
//        inorder(root.left);
//        list.add(root.val);
//        if((root.right == null && root.left!=null) ){
//            if(root.right == null) {
//                list.add(-1);
//            }
//        }
//        inorder(root.right);
//
//    }
}