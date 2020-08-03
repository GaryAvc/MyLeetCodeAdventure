import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.grayCode(2));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

}