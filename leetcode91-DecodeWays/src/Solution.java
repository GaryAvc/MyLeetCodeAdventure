class Solution {
    public int numDecodings(String s) {

        char[] values = s.toCharArray();

        return -1;
    }

    /*
    Invirance:
        1. when the value is 1 or 2, it will cause special case
        2. when it is 1 : it can attach 0~9
        3. when it is 2 : it can only attach 0~6 ( include 6 )
        4. when 1,2 is going to recursion into 1,2 DO NOT add 1, only when it is going recursion into
            0,3,4,5,6,7,8,9, then add 1 into the answer
        5. when decide to run it into a 2 digits answer, add 1 into the answer
        6. only if when it is the last digit, do NOT consider the 1,2 possible
     */
    private int dp ( char[] values, int index, int ways ){

        // when reach the end of the array
        if( index == values.length){
            return 0;
        }

        // 6. make sure that it is not the last digit
        if( index != values.length -1 ) {
            if (values[index] == '1') {
                if( values[index+1] =='1' || values[index+1] =='2'){
                    ways++;
                    dp(values,index+1,ways);
                    dp(values,index+2,ways);
                }else{
                    ways++;

                }
            } else if( values[index] == '2'){
                if( values[index+1] =='1' || values[index+1] =='2'){
                    ways++;
                    dp(values,index+1,ways);
                }else{
                    ways++;
                }
            }
        }

        return -1;
    }

}