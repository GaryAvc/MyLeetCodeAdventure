import java.util.*;

/*
Invariance:
    1. There are 2 situations that can lead to false, (1) the courses you need to take > numCourses
       (2) A course's prereq's prereq is this course
    2. the prereqs come in pairs,
    3. prereqs pair can contain same courses, [1,2,3] (prereq) for [4] is express as [1,4][2,4][3,4]
    4. (1) can be solve by a set
    5. (2) can be solve by a map, which check after the map is built every key's array's each item's value (the array) contain this origin key
        or not
    6. check for loop situation, should use a temp set and recursion, where the situation can go wrong is that when the AL(prereq) contain
        any values from the temp set ( where store all the courses ) which means it accomplish a loop which lead to false
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] x ={{1,0},{2,1}};
        System.out.println(s.canFinish(3,x));
    }

    Set<Integer> highLevelCourse;
    Map<Integer, ArrayList<Integer>> map;
    boolean answer;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        highLevelCourse = new HashSet<>();
        answer = true;
        Set<Integer> totalReq = new HashSet<>();
        map = new HashMap<>();

        // check if there is enough courses that you can take by using a set
        int length = prerequisites.length;
        for( int i =0;i<length;i++){
            int pre = prerequisites[i][0];
            int course = prerequisites[i][1];

            // fill up the set
            if(!totalReq.contains(pre)){
                totalReq.add(pre);
            }
            if(!totalReq.contains(course)){
                totalReq.add(course);
            }

            // fill up the map
            if(!map.containsKey(course)){
                ArrayList<Integer> prereqs = new ArrayList<>();
                prereqs.add(pre);
                map.put(course,prereqs);
            }else{
                map.get(course).add(pre);
            }
            
        }
            // check if there is enough courses
        if( numCourses < totalReq.size()){
            answer=false;
        }

        // check if the prereq is valid
        for (int course: map.keySet()) {

            dfs(course);
            highLevelCourse.remove(course);
//            ArrayList<Integer> prereqs = map.get(course);
//            for (int req: prereqs) {
//                if( map.containsKey(req)&& map.get(req).contains(course)){
//                    return false;
//                }
//            }
        }


        return answer;
    }

    private void dfs(int course) {

        // base case : when map do NOT conatin this course (which means it does NOT have any prereqs)
        if(!map.containsKey(course)){
            return;
        }

        // when this prereq course collapse with higher lever course, it is wrong
        if(highLevelCourse.contains(course)){
            answer=false;
            return;
        }

        highLevelCourse.add(course);

        ArrayList<Integer> prereqs = map.get(course);
        for (int prereq: prereqs) {
//            highLevelCourse.add(prereq);
            dfs(prereq);
            highLevelCourse.remove(prereq);
        }



    }
}