import java.util.HashMap;
import java.util.Map;

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

//
//class Solution {
//    private Map<Integer, Integer> indexMap;
//
//    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left,
//                                int preorder_right, int inorder_left, int inorder_right) {
//        if (preorder_left > preorder_right) {
//            return null;
//        }
//
//        // 前序遍历中的第一个节点就是根节点
//        int preorder_root = preorder_left;
//        // 在中序遍历中定位根节点
//        int inorder_root = indexMap.get(preorder[preorder_root]);
//
//        // 先把根节点建立出来
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        // 得到左子树中的节点数目
//        int size_left_subtree = inorder_root - inorder_left;
//        // 递归地构造左子树，并连接到根节点
//        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
//        root.left = myBuildTree(preorder, inorder,
//                preorder_left + 1,
//                preorder_left + size_left_subtree,
//                inorder_left, inorder_root - 1);
//        // 递归地构造右子树，并连接到根节点
//        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
//        root.right = myBuildTree(preorder, inorder,
//                preorder_left + size_left_subtree + 1, preorder_right,
//                inorder_root + 1, inorder_right);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        // 构造哈希映射，帮助我们快速定位根节点
//        indexMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, inorder, 0, n - 1,
//                0, n - 1);
//    }
//}

class Solution {
    int[]preorder;
    int[]inorder;
    Map<Integer,Integer> map;

    public static void main(String[] args) {
        int[]pre = {3,9,20,15,7};
        int[]in = {9,3,15,20,7};

        Solution s = new Solution();
        s.buildTree(pre,in);

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        map = new HashMap<>();

        for( int i =0; i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode answer = helper(0,preorder.length-1,
                0,inorder.length-1);
        return answer;

    }

    private TreeNode helper(int preorderLeft,int preorderRight,int inorderLeft,int inorderRight) {

        if(preorderLeft>preorderRight){
            return null;
        }

        int rootValue = preorder[preorderLeft];
        int inorderRoot = map.get(rootValue);
        int leftSize = inorderRoot - inorderLeft;
        int rightSize = inorderRight - inorderRoot;

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorderLeft+1,preorderLeft+leftSize,inorderLeft,inorderRoot-1);
        root.right = helper(preorderLeft+leftSize+1,preorderRight,inorderRoot+1,inorderRight);
        return root;

    }
}

