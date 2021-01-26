class Solution {


    public int romanToInt(String s) {

        char[] eachChar = s.toCharArray();

        int answer=0;

        for(int i =0;i<eachChar.length;i++){

            char thisChar = eachChar[i];
            if( i==eachChar.length-1){
                answer+=charToInt(thisChar);
            }else {
                char nextChar = eachChar[i+1];
                StringBuilder sb= new StringBuilder();
                sb.append(eachChar[i]);
                sb.append(nextChar);
                String combine = sb.toString();

                if(combine.equals("IV")){
                    answer+=4;
                    i++;
                }else if(combine.equals("IX")){
                    answer+=9;
                    i++;
                }else if(combine.equals("XL")){
                    answer+=40;
                    i++;
                }else if(combine.equals("XC")){
                    answer+=90;
                    i++;
                }else if(combine.equals("CD")){
                    answer+=400;
                    i++;
                }else if(combine.equals("CM")) {
                    answer += 900;
                    i++;
                }else{
                    answer+=charToInt(thisChar);
                }
            }

        }

        return answer  ;
    }

//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public int charToInt(char c){

        int value =0;
        switch (c){
            case 'I' :value=1;break;
            case 'V' :value=5;break;
            case 'X' :value=10;break;
            case 'L' :value=50;break;
            case 'C' :value=100;break;
            case 'D' :value=500;break;
            case 'M' :value=1000;break;
            default :value=0;
        }
        return value;
    }

}