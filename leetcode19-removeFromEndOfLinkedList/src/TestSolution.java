import org.junit.Test;

public class TestSolution {
    @Test
    public void wholeTest(){
        Solution s = new Solution();
        ListNode n=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new
                ListNode(5,null)))));
        ListNode n2=new ListNode(1,new ListNode(2,null));
        s.removeNthFromEnd(n2,2);
    }

}
