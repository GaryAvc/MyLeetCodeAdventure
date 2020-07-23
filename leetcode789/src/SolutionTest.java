public class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ghost = {{1,9},{2,-5},{3,8},{9,8},{-1,3}};
        int[] target = {8,-10};

        System.out.println(s.escapeGhosts(ghost,target));
    }
}
