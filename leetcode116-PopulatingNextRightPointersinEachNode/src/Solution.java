import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class Solution {

    Node answer;
    Queue<Node> level;

    /*
    Invirance:
    1. useing bfs to get all leaf node at same level
    bfs:
    1. use queue to store nodes
    2. poll one node and add it's children into queue
    3, Since it require the leaf at the same level, add {size} and one more {loop} to poll out all leaves at
    the same level
     */
    public Node connect(Node root) {
        answer = root;
        level = new ArrayDeque<>();

        if( root ==null){
            return root;
        }

        level.add(answer);
        bfs();

        return answer;
    }

    private void bfs(){

        int size = level.size();

        // base case : when empty, return (when empty means traverse the whole tree)
        if(size==0){
            return;
        }

        for( int i =0;i<size;i++){

            Node left = level.poll();

            // connet left to right - if is the rightest node, connect it with null
            if( i !=size-1){
                Node right = level.peek();
                left.next=right;
            }else{
                left.next=null;
            }

            // add it's left and right to queue
            if(left.left!=null){
                level.add(left.left);
            }
            if(left.right!=null ){
                level.add(left.right);
            }
        }

        bfs();

    }
}