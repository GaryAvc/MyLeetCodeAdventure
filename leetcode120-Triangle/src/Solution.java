import java.util.LinkedList;
import java.util.List;


class Solution {

    /*
    Invirance:
    1. bottom lever do Not need to change
    2. this level Sum value = this level value + lower level adjacent smaller value
    3. the lower level adjacent index is {index}, {index+1}
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        for( int i = triangle.size()-2;i>=0;--i){
            for( int j=0;j< triangle.get(i).size();j++){
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}