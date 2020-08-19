
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

    boolean answer;

    public boolean isValidBST(TreeNode root) {

        answer = true;

        if( root == null){
            return true;
        }

        isValidBSTHelper(root);

        return answer;
    }

    /*
    this function check the parent node Recursively,
    check if this parent node is valid:
        left < val, right > val
    BaseCase: when left, right is all null
     */
    private void isValidBSTHelper ( TreeNode node){

        // base case: when reach leaf node
        if( node.left == null && node.right == null ){
            return;
        }

//        // stop process below when isValid is false already
//        if ( !isValid ){
//            return isValid;
//        }

        // check if this node is valid
        if( node.left == null || node.right ==null ){
            if( node.left ==null){
                if( node.right.val <= node.val ){
                    answer = false;
                    return;
                }
                isValidBSTHelper(node.right);
            }
            if(node.right==null){
                if ( node.left.val >= node.val){
                    answer = false;
                    return;
                }
                isValidBSTHelper(node.left);
            }
        }else{
           if (  node.right.val <= node.val || node.left.val  >= node.val ){
               answer = false;
               return;
           }
           isValidBSTHelper(node.left);
           isValidBSTHelper(node.right);
        }

    }

}