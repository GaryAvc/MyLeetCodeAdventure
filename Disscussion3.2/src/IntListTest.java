public class IntListTest {
    public static void main(String[] args) {
        IntList x = new IntList(1,null);
        x.rest=new IntList(2,new IntList(2,new IntList(2,new IntList(3,null))));
        x.removeDuplicates(x);
    }
}
