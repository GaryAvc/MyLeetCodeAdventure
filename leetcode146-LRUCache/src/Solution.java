import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


class LRUCache {

    public static void main(String[] args) {
        LRUCache s = new LRUCache(10);
        String[] order = {"put","put","put","put","put","get","put","get","get","put","get",
                "put","put","put","get","put","get","get","get","get","put","put",
                "get","get","get","put","put","get","put","get","put","get","get",
                "get","put","put","put","get","put","get","get","put","put","get",
                "put","put","put","put","get","put","put","get","put","put","get",
                "put","put","put","put","put","get","put","put","get","put","get",
                "get","get","put","get","get","put","put","put","put","get","put",
                "put","put","put","get","get","get","put","put","put","get","put",
                "put","put","get","put",
                "put","put","get","get","get","put","put","put","put","get","put",
                "put","put","put","put","put","put"};
        List<int[]> lists = new ArrayList<>();

       try{
           File myObj = new File("/Users/mac/WorkSpace/LeetCodeWorkSpace/leetcode138-CopyListwithRandomPointer/src/nums.txt");
           Scanner myReader = new Scanner(myObj);
           int count =0;
           while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               if(data.contains(",")){
                   System.out.print("PUT ");

                   int splitIndex = data.indexOf(',');
                   String first = data.substring(0,splitIndex);
                   String second = data.substring(splitIndex+1);
                   int fir = Integer.parseInt(first);
                   int sec = Integer.parseInt(second);

                   System.out.print(fir);
                   System.out.print(" " + sec + " null \n");
                   s.put(fir,sec);
               }else{
                   System.out.print("GET " + data + " "+ s.get(Integer.parseInt(data)) + "\n");
               }
               count++;
//               System.out.println(data);
           }
           myReader.close();
       }catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }


    }


    /*
    Invariance:
    1. Stack can be a good data structure to keep update the age of all process
    2. A map should be used to maintain the key and value
     */

    Queue<Integer> age;
    Map<Integer,Integer> map;
    int size;

    public LRUCache(int capacity) {
        age=new ArrayDeque<>();
        map = new HashMap<>();
        size=capacity;
    }

    /*
    Invariance:
    1. get should renew the age of all items
     */
    public int get(int key) {

        // check if the key exists, if yes, return index, if not, return -1
        if(map.containsKey(key)){

            // update age
            renew(key,false);

            // return value
            return map.get(key);
        }else{
            return -1;
        }


    }

    public void put(int key, int value) {

        if( map.containsKey(key)){
            map.replace(key,value);
            renew(key,false);
        }else {
            renew(key , true);
            map.put(key,value);

        }
    }

    // if putOperation: renew and remove
    // if not putOperation: only renew the order

    private void renew(int key,boolean putOperation) {

        // renew the age if the key exists

        if( putOperation){
            if(age.size()>=size){
                int removedKey = age.poll();
                age.add(key);
                map.remove((removedKey));
            }else{
                if(!age.contains(key)){
                    age.add(key);
                }
            }
        }else{
            age.remove(key);
            age.add(key);
        }

//        if(age.size()>=size){
//            int removedKey = age.poll();
//            age.add(key);
//            if(putOperation){
//                map.remove(removedKey);
//            }
//        }else{
//            if(!age.contains(key)){
//                age.add(key);
//            }
//        }

    }
}
