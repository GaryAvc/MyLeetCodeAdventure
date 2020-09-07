import java.util.ArrayList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
    Requirement: O(nlgn) space: O(1)
    Invariance:
        1. it should has 2 extra functions : merge and sort
        2. no idea how to not use extra space but try to make it run first
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        [4,2,1,3]
        ListNode x = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));

        s.sortList(x);
    }
    ArrayList<Integer> arr;

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        arr = new ArrayList<>();
        ListNode temp = head;
        ListNode answer = new ListNode();
        ListNode tempAnswer = answer;
        while( temp!=null ){
            arr.add(temp.val);
            temp=temp.next;
        }

        sort(0,arr.size()-1);
        answer.val=arr.get(0);
        for(int i=1;i<arr.size();i++){
            ListNode loop = new ListNode(arr.get(i));
            tempAnswer.next=loop;
            tempAnswer=tempAnswer.next;
        }


        return answer;
    }

    private void sort(int l ,int r){

        if(l<r){
            int mid = (r-l)/2+l;
            sort(l,mid);
            sort(mid+1,r);
            merge(l,r,mid);
        }

    }

    private void merge(int l,int r, int mid){

        // initial the left and right array
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i =l;i<=mid;++i){
            left.add(arr.get(i));
        }
        for(int j = mid+1;j<=r;++j){
            right.add(arr.get(j));
        }

        // merge the 2 array Together
        int leftIndex=0;
        int rightIndex=0;
        int arrIndex=l;

        while(leftIndex<left.size() && rightIndex<right.size()){
            if(left.get(leftIndex)< right.get(rightIndex)){
                arr.set(arrIndex,left.get(leftIndex));
                leftIndex++;
            }else {
                arr.set(arrIndex,right.get(rightIndex));
                rightIndex++;
            }
            arrIndex++;
        }

        // if left part has someting remain
        while( leftIndex < left.size()){
            arr.set(arrIndex,left.get(leftIndex));
            arrIndex++;
            leftIndex++;
        }

        // if right part has someting remain
        while( rightIndex < right.size()){
            arr.set(arrIndex,right.get(rightIndex));
            arrIndex++;
            rightIndex++;
        }

    }


}