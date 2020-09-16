import java.util.*;

/*
Invariance:
    1. Check if the last course's value is <= numCourses, if not - return []
    2. Check if there exist loops in the course, if yes - return []
    3. Record the depth of every courses [A,B]
        (1) Store all course in a map, key - courseNO, value - depth
        (2) initial every B as 0
        (3) A.value = Math.max(A.value,B+1)
 */


class Solution {

    Set<Integer> highLevelCourse;
    Map<Integer, ArrayList<Integer>> map;
    boolean answer;

    Map<Integer,Integer> depth;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]x = {{1,2}};
        s.findOrder(3,x );
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        depth = new HashMap<>();
        highLevelCourse = new HashSet<>();
        answer = true;
        Set<Integer> totalReq = new HashSet<>();
        map = new HashMap<>();
        int [] answerList;
        depth =new HashMap<>();



        // check if there is enough courses that you can take by using a set
        int length = prerequisites.length;
        for (int i = 0; i < length; i++) {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];

            // fill up the set
            // keep record the depth
            if (!totalReq.contains(pre)) {
                totalReq.add(pre);
                // if there is no pre before, initial the pre to 0
                depth.put(pre,0);
            }
            if (!totalReq.contains(course)) {
                totalReq.add(course);
                depth.put(course,depth.get(pre)+1);
            }else{
                int larger = Math.max(depth.get(course),depth.get(pre)+1);
                depth.put(course,larger);
            }

            // fill up the map
            if (!map.containsKey(course)) {
                ArrayList<Integer> prereqs = new ArrayList<>();
                prereqs.add(pre);
                map.put(course, prereqs);
            } else {
                map.get(course).add(pre);
            }
        }
        answerList = new int[numCourses];

        // check if there is enough courses
        if (numCourses < totalReq.size()) {
            answer = false;
        }

        // check if the prereq is valid
        for (int course : map.keySet()) {

            dfs(course);
            highLevelCourse.remove(course);
        }

        if(prerequisites.length==0) {
           int [] specialCase = new int[numCourses];
           for(int i =0;i<numCourses;i++){
               specialCase[i]=numCourses-1-i;
           }
           return specialCase;
        }

        if(!answer){

            return new int[0];
        }else {
            // sort the map by value and asescending order
            LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
            depth.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            // if the size of the list is equal to num required
            if (sortedMap.size() == numCourses){
                // turn the map into array,
                int i = 0;
                for (int course : sortedMap.keySet()) {
                    answerList[i] = course;
                    i++;
                }
            }else{
                int gap = numCourses - sortedMap.size();
                int maxCourse=-1;
                int i = gap;
                for (int course : sortedMap.keySet()) {
                    answerList[i] = course;
                    i++;
                    maxCourse = Math.max(maxCourse,course);
                }

                for(int j =0;j<gap;++j){
                    answerList[j]=maxCourse+1;
                }

            }

            return answerList;
        }


    }

    private void dfs(int course) {

        // base case : when map do NOT conatin this course (which means it does NOT have any prereqs)
        if (!map.containsKey(course) || answer == false) {
            return;
        }

        // when this prereq course collapse with higher lever course, it is wrong
        if (highLevelCourse.contains(course)) {
            answer = false;
            return;
        }

        highLevelCourse.add(course);

        ArrayList<Integer> prereqs = map.get(course);
        for (int prereq : prereqs) {
            dfs(prereq);
            highLevelCourse.remove(prereq);
        }
    }
}
