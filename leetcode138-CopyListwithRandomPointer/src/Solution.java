
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


class Solution {
    public Node copyRandomList(Node head) {

        Node answer = new Node(head.val);
        Node answerTemp;
        Node temp = head;

        // this loop create new memory space and set {next} part
        while ( temp.next!=null){

            int val = temp.val;
            answerTemp = new Node(val);

            int nextVal =temp.next.val;
            Node answerNextTemp = new Node(nextVal);

            answerTemp.next=answerNextTemp;

            answerTemp=answerNextTemp;
            temp=temp.next;
        }

        temp=head;
        answerTemp=answer;
        // this loop set the {random} part
        while( temp!=null){

            if(temp.random!=null){
                answerTemp.random = temp.random;
            }
            answerTemp=answerTemp.next;
            temp=temp.next;
        }
        return answer;
    }
}