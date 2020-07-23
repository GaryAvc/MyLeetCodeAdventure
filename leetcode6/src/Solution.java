import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private   Map<Integer, ArrayList<String>> zig = new HashMap<>();

    /** Invirance:
     * 1. the size of one round is 2row-2
     * 2. 0 <= r < row-1 ,add in the hashmap 0 to row-1
     * 3. row <= r < 2row-2, add from hashmap(row-1-1) to hashmap(1)
     * 4. when add, add the string in zigzap Value array
     */
    public String convert(String s, int numRows) {
        if(s.equals("")){
            return "";
        }
        if(numRows<2){
            return s;
        }
        addValue(s,numRows);
        return print(numRows);
    }

    public String print(int numRows){
        String result="";
        for(int i=0;i<numRows;++i){
            ArrayList<String> eachRowString = zig.get(i);
            if(eachRowString==null){
                return result;
            }else{
                for (int j=0;j<eachRowString.size();++j){
                    String getString =eachRowString.get(j);
                    result = result.concat(getString);
                }
            }

        }
        return result;
    }
//"PINALSIGYAHRPI"
    public void addValue(String s,int row){

        int oneset;
        if(s.length()>row&&s.length()>2){
            oneset=2*row-2;
        }else{
            oneset=row;
        }

        for(Integer i =0;i<s.length();++i){


           if(i%oneset<=row-1){
               ArrayList<String> va =zig.get(i%oneset);
               if(va!=null){
                   va.add(s.substring(i,i+1));
               }else{
                   ArrayList<String> newv = new ArrayList<>();
                   newv.add(s.substring(i,i+1));
                   zig.put(i,newv);
               }
           }else{
               for(int j=0;j<row-2 && i+j<s.length();j++){
                   int zindex = row-2-j;
                   ArrayList<String> seconda = zig.get(zindex);
                   seconda.add(s.substring(i+j,i+j+1));
                   zig.put(zindex,seconda);
               }
               i+=row-3;
           }


        }

    }

}
