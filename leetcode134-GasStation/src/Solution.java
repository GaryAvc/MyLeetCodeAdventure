import java.util.ArrayList;

class Solution {

    /*
    Invariance:
    1. Start position: cost <= gas
    2. Total cost <= Total gas
    3. if 1 and 2 can not be filled, return -1
    4. maybe put all possible starting position in a queue, counting the remaining gas to see if it is a
    possible result, if yes return index
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalCost= 0;
        int totalGas = 0;
        ArrayList<Integer> startIndex = new ArrayList<>();

       for( int i=0;i<gas.length;++i){

           // if the cost <= gas -> it is a valid start position
            if( cost[i]<=gas[i]){
                startIndex.add(i);
            }

            totalCost +=cost[i];
            totalGas += gas[i];
       }

        // check if total cost <= total gas
        if(totalCost>totalGas){
            return -1;
        }

        /*
        Invariance:
        1. the gasRemain = gasRemain + gas - cost
        2. when gasRemain < 0, not Valid
        3. you need to travel back to the Start index to be valid
        4. when the next time it reach the start index (since the not valid situation will break the loop)
        5. you need to loop length time to get back to the original position
        6. when index >= length-1, set index to 0
         */

        // loop the array to see if it is valid
        for( int i =0;i<startIndex.size();++i){

            int start = startIndex.get(i);
            int gasRemain = 0;
            int tempIndex = start;

            for(int j=0;j<=cost.length;++j){

                if(j==cost.length){
                    return start;
                }
                gasRemain= gasRemain + gas[tempIndex] - cost[tempIndex];

                if(gasRemain<0){
                    break;
                }
                tempIndex++;

                // 6.
                if(tempIndex == cost.length){
                    tempIndex=0;
                }


            }

        }
        return -1;

    }
}