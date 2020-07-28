
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

 public class Solution {
    ListNode pointerN;
    ListNode pointerEnd;
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null){
            return null;
        }
        if( defineTwoNodes(head,n)!=null){
            return defineTwoNodes(head,n);
        }
        moveNodes();
        removeNode();
        return head;
    }

    /*
    this function take the origin listnode and n, to determin the 2 listnode for later use
     */
     protected ListNode defineTwoNodes(ListNode head, int n){
         pointerEnd=head;
         pointerN=head;
         for(int i=0;i<n+1;++i){
             if(pointerEnd==null){
                 return pointerN.next;
             }
            pointerEnd=pointerEnd.next;
         }
         return null;
     }

     /*
     this function use recursive call to move these two node in to correct position
      */
     protected void moveNodes(){
         if(pointerEnd==null){
             return;
         }
         pointerEnd=pointerEnd.next;
         pointerN=pointerN.next;
         moveNodes();
     }

     /*
     this function happened when two nodes are in coreect position, and remove
     the required node
      */
     protected void removeNode(){
         pointerN.next=pointerN.next.next;
     }

}