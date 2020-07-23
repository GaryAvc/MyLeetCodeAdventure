class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        /** Invirance:
         *    1. totally you need tx+ty steps to get out
         *    2. the ghost can also move tx+ty steps
         *    3. if one ghost also can reach the target u loose
         */

        int escapeDistance = Math.abs(target[0])+Math.abs(target[1]);
        boolean escape =true;

        for ( int i =0;i<ghosts.length;++i){
            int ghostDistance =Math.abs(ghosts[i][0]-target[0])
                    +Math.abs(ghosts[i][1]-target[1]);
            if( ghostDistance <= escapeDistance){
                escape = false;
                break;
            }
        }
        return escape;

    }
}