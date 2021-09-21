import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();

        boolean intersect = false;

        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }

        while(set.add(headB) && headB!=null){
            headB = headB.next;
        }

        return headB;

    }
}