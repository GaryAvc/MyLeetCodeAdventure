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
    TreeNode p;
    TreeNode q;
//    Boolean found = false;
//    TreeNode root;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        stackP=new Stack<>();
        stackQ=new Stack<>();
        this.p = p;
        this.q = q;
        // initial the stack with root
        stackP.push(root);
        stackQ.push(root);
        // find 2 nodes
        dfs(root,new Stack<TreeNode>());


        // check the 2 stack to see the lowerst common ancestor
        int sizep = stackP.size();

        for (int i = 0; i < sizep; i++) {
            TreeNode answer = stackP.pop();
            if (stackQ.contains(answer)) {
                return answer;
            }
        }

        return root;
    }

    // find the target and record the parent
    private void dfs(TreeNode parent , Stack<TreeNode> stack ) {

        // base case: when the node is target node, or this node is null
        if( parent == null ){
            return;
        }

        if(parent == p ){
            stackP.addAll(stack);
        }

        if(parent == q){
            stackQ.addAll(stack);
        }


        // recursively call the dfs with left and right child
        stack.push(parent.left);
        dfs(parent.left,stack);
        stack.remove(parent.left);
        stack.push(parent.right);
        dfs(parent.right,stack);
        stack.remove(parent.right);


    }

  }