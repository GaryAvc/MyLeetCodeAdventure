import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> list = new LinkedList<>();
        for( int i = 1;i<n+1;i++){


            if(i %15==0){
                list.add("FizzBuzz");
            }else if (i % 5 == 0){
                list.add("Buzz");
            }else if (i % 3 ==0){
                list.add("Fizz");
            }else{
                list.add(""+i);
            }

        }
        return list;
    }

}