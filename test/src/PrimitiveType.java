import java.util.LinkedList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PrimitiveType {

    public static void main(String[] args) {
       ListNode node1 = new ListNode(1);
       System.out.println(node1.val);
       changeValue(node1);
       System.out.println(node1.val);

        String letter = "a";
        System.out.println(letter);
        changeValue(letter);
        System.out.println(letter);

        List list = new LinkedList();
        list.add(1);
        System.out.println(list);
        changeValue(list);
        System.out.println(list);
    }

   private static void changeValue(ListNode node){
        node.val=2;
   }

    private static void changeValue(List list){
        list.add(2);
    }

    private static void changeValue(String s){
        s="changed";
    }
}

