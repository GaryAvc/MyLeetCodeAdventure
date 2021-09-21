/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }
        int length = 0;

        ListNode temp = head;

        while(temp!=null){
            temp = temp.next;
            length++;
        }

        int [] list = new int[length];

        temp = head;

        int i = 0;
        while(temp!=null){
            list[i] = temp.val;
            temp = temp.next;
            i++;
        }

        ListNode answer = new ListNode(list[length-1]);
        ListNode x = answer;
        for(int k = list.length-2;k>=0;k--){
            ListNode tmp = new ListNode(list[k]);
            x.next = tmp;
            x = x.next;
        }
        return answer;
    }


}