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

public class Solution {

    List<List<Integer>> answer;
    List<Integer> single;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        answer = new LinkedList<>();
        single = new LinkedList<>();
        if(root==null){
            return answer;
        }
        single.add(root.val);
        dfs(0,sum,root);
        return answer;
    }

    private void dfs( int sum, int targetSum,TreeNode node){

        if( node == null){
            return;
        }

        sum += node.val;



        if(node.left == null && node.right == null){
            if( sum == targetSum){
                answer.add(new LinkedList<>(single));
            }
            return;
        }

        if( node.left != null){
            single.add(node.left.val);
            dfs( sum,targetSum,node.left);
            single.remove(single.size()-1);
        }

        if( node.right != null){
            single.add(node.right.val);
            dfs( sum,targetSum,node.right);
            single.remove(single.size()-1);
        }

    }

}