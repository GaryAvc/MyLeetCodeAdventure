import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        int [] test = {1,1,1,1,2,2,3};
        s.topKFrequent(test,2);
    }
    public int[] topKFrequent(int[] nums, int k) {

        Hashtable<Integer,Integer> hash = new Hashtable<>();
        for( int num:nums){

            hash.put(num, hash.getOrDefault(num,0)+1);

        }

//        bucketsort
        List<Integer>[] list = new List[nums.length+1];

        for( int key:hash.keySet()){
            if(list[hash.get(key)]!=null){
                list[hash.get(key)].add(key);
            }else{
                list[hash.get(key)] = new LinkedList<>();
                list[hash.get(key)].add(key);
            }
        }

//        return value

        int count = 0;
        int[] answer = new int[k];
        int ansind = 0;
        for( int i =list.length-1;i>=0&&count<k;i--){
            if(list[i]!=null){

                for( int x : list[i]){
                    if(ansind == k){
                        continue;
                    }
                    answer[ansind] = x;
                    ansind++;
                }
            }
        }
        return answer;

    }
}