
class Solution {



     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next =null;
         }
     }

//    public ListNode addLast (ListNode ln, int val){
//        if(ln!=null){
//            ListNode tempNode = new ListNode(val);
//            ln.next = tempNode;
//        }else{
//            ln = new ListNode(val);
//        }
//        return ln;
//    }

    /** Invirance:
     * 1. the new number is val1+val2 + plus % 10
     * 2. if val1+val2 >10, we need to add 1 in next digit
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1,l2,0);
    }

    public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2,int plus) {
        if(l1==null&&l2==null){
            if(plus ==1){
                ListNode answerNodeFinal1= new ListNode( 1);
                answerNodeFinal1.next = addTwoNumbersHelper(l1,l2,0) ;
                return answerNodeFinal1;
            }else {
                return null;
            }
        }
        int newDigitVal;
        int newPlus = 0;
        if(l1 ==null){
            newDigitVal = (plus+l2.val)%10;
            if(plus+l2.val>=10){
                newPlus=1;
            }
        }else if (l2==null){
            newDigitVal =(plus+l1.val)%10;
            if(l1.val+plus>=10){
                newPlus=1;
            }
        }else{
            newDigitVal = (plus+l1.val+l2.val)%10;
            if(plus+l1.val+l2.val>=10){
                newPlus=1;
            }
        }

        ListNode answerNode= new ListNode( newDigitVal );
        if(l1==null){
            answerNode.next = addTwoNumbersHelper(l1,l2.next,newPlus) ;
        }else if (l2==null){
            answerNode.next = addTwoNumbersHelper(l1.next,l2,newPlus) ;
        }else{
            answerNode.next = addTwoNumbersHelper(l1.next,l2.next,newPlus) ;
        }

        return answerNode;
    }

}