import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next =null;
             }
         }

    public static void main(String[] args) {
        Solution s = new Solution();
        Solution.ListNode l1 = new Solution.ListNode(2);
        Solution.ListNode l2 = new Solution.ListNode(5);
        l1.next=new Solution.ListNode(4);
        l1.next=new Solution.ListNode(3);
        l2.next = new Solution.ListNode(6);
        l2.next = new Solution.ListNode(4);
        s.addTwoNumbers(l1,l2);
    }
}
