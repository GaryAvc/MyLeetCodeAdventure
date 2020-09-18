import com.sun.source.tree.Tree;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  /*
  Invariance:
  1. use DFS which search for these 2 nodes
  2. use 2 stack to store their parents
  3. LOWEST Comment: poll from 1 stack and use it to check if contains in other, if yes, return it
   */
public class Solution {

      public static void main(String[] args) {
          Solution s = new Solution();
          TreeNode root =new TreeNode(3);
          TreeNode q =new TreeNode(5);
          TreeNode p = new  TreeNode(4);
          root.left =q;
          root.right =new TreeNode(1);
          root.left.left=new TreeNode(6);
          root.left.right = new TreeNode(2);
          root.left.right.right = p;
          s.lowestCommonAncestor(root,p,q);
      }

    Stack<TreeNode> stackP;
    Stack<TreeNode> stackQ;
    Boolean found = false;
//    TreeNode root;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        stackP=new Stack<>();
        stackQ=new Stack<>();
        // initial the stack with root
        stackP.push(root);
        stackQ.push(root);
        // find 2 nodes
        dfs(root,p,new Stack<TreeNode>(),0);

        // reset found value
        found =false;
        dfs(root,q,new Stack<TreeNode>(),1);

        // check the 2 stack to see the lowerst common ancestor
        int sizep = stackP.size();
        int sizeq = stackQ.size();

        if( sizep>sizeq) {
            for (int i = 0; i < sizep; i++) {
                TreeNode answer = stackP.pop();
                if (stackQ.contains(answer)) {
                    return answer;
                }
            }
        }else{
            for (int i = 0; i < sizeq; i++) {
                TreeNode answer = stackQ.pop();
                if (stackP.contains(answer)) {
                    return answer;
                }
            }
        }

        return root;
    }

    // find the target and record the parent
    private void dfs(TreeNode parent, TreeNode target, Stack<TreeNode> stack, int type) {

        // base case: when the node is target node, or this node is null
        if( parent == null ){
            return;
        }

        if(parent == target){
            found = true;

            // modify the stack
            if(type==1){
                stackQ.addAll(stack);
            }else{
                stackP.addAll(stack);
            }


        }

        // if already found, then just return, stop
        if (found){
            return;
        }

        // recursively call the dfs with left and right child
        stack.push(parent.left);
        dfs(parent.left,target,stack,type);
        if (!found) {
            stack.remove(parent.left);
        }
        if (!found) {
            stack.push(parent.right);
        }
        dfs(parent.right,target,stack,type);
        if (!found) {
            stack.remove(parent.right);
        }

    }

  }