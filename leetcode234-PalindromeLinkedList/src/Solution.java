

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode x = new ListNode(1);
        x.next=new ListNode(2);
        s.isPalindrome(x);
    }
    public boolean isPalindrome(ListNode head) {

        int length = 0;

        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            length++;
        }

        int [] elements = new int[length];
        int index = 0;
        while(head!=null){
            elements[index] = head.val;
            head = head.next;
            index++;
        }

//        test if elements is palindrome
        int left = 0;
        int right = elements.length-1;
        while(left<right){
            if(elements[left]!=elements[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}