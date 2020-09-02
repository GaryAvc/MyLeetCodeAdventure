import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class Solution {
    public Node copyRandomList(Node head) {

        if(head==null){
            return  null;
        }

        Node answer = new Node(head.val);
        Node answerTemp = answer;
        Node temp = head;

        // add a map to store the new and old node
        Map<Node,Node> oldNew = new HashMap<>();
        // initial map
        oldNew.put(head,answer);

        // this loop create new memory space and set {next} part
        while ( temp.next!=null){

            int nextVal =temp.next.val;
            Node answerNextTemp = new Node(nextVal);

            answerTemp.next=answerNextTemp;

            answerTemp=answerNextTemp;
            temp=temp.next;
            oldNew.put( temp,answerTemp);
        }

        temp=head;
        answerTemp=answer;
        // this loop set the {random} part
        while( temp!=null){

            if(temp.random!=null){
                answerTemp.random = oldNew.get(temp.random);
            }
            answerTemp=answerTemp.next;
            temp=temp.next;
        }
        return answer;
    }
}