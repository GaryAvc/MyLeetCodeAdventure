import java.util.ArrayList;

class Solution {



    int[]answer ;
    int[]visited ; // representation: 0 - not visited, 1 - visited, 2 - added into stack
    boolean isLoop;
    int answerSize;
    ArrayList<ArrayList<Integer>> edges;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]x={{1,0}};
        s.findOrder(2,x);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        answer = new int[numCourses];
        visited = new int[numCourses];
        edges = new ArrayList<>();
        isLoop= false;
        answerSize =numCourses;



        // (1) build the structure, [A,B], B -> A
        // the index is - B, the array contain the all - A s
        for(int i =0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] preReq:prerequisites){
            edges.get(preReq[1]).add(preReq[0]);
        }

        for(int visit:visited){
            visit=0;
        }

        // if the numCourse is not enough
        if(edges.size()>numCourses){
            return new int[0];
        }
        // (2) topological sort
        // the answer seems to set that all the courses are sequential and start from 0
        for(int i =0;i<numCourses;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }

        if(isLoop){
            return new int[0];
        }
        return answer;
    }

    private void dfs(int index) {

        // make it visited
        visited[index]=1;

//        // base case: when it's NOT other course's preReq, which equals to the array is empty,
//        //      add it into stack
//        if(edges.get(index).size()==0){
//            answer[answerSize-1] = index;
//            answerSize--;
//            return;
//        }

        // loop through the index's next courses, if reach the visited, break;
        for(int next:edges.get(index) ){
            if(visited[next]==0){
                dfs(next);
                if(isLoop){
                    return;
                }
            }else if(visited[next]==1){
                isLoop = true;
                return;
            }
        }

        answer[answerSize-1] = index;
        visited[index]=2;
        answerSize--;

    }
}