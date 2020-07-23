class Solution {
    public int minimumSwap(String s1, String s2) {
        /** Invirance:
         * 1. if the total num of x and y are not eauqal, it is impossible to make it           *    equal, return -1.
         * 2. 2 base case: 1. {xx} {yy} -> 1 swap 2. {xy} {yx} -> 2 swap
         * 3. To get less swap, implement case 1 amap
         * 4. If the two arraies has the same values in the same position, leave it
         * 5. count the different values in one array, the swap = countX/2+countY/2+2
         */

        int totalX=0;
        int totalY=0;
        int countX = 0;
        int countY=0;
        for ( int i=0;i<s1.length();++i){
            if( !(s1.charAt(i)==(s2.charAt(i)))){
                if(s1.charAt(i)=='x'){
                    countX++;
                }else{
                    countY++;
                }


            }
            if(s1.charAt(i)=='x'){
                totalX++;
            }
            if( s2.charAt(i)=='x'){
                totalX++;
            }
            if (s1.charAt(i)=='y' ){
                totalY++;
            }
            if( s2.charAt(i)=='y'){
                totalY++;
            }

        }
        if(totalX%2 !=0 || totalY%2!=0){
            return -1;
        }else if (countX%2==0 && countY%2==0){
            return countX/2+countY/2;
        }else{
            return countX/2+countY/2+2;
        }
    }
}