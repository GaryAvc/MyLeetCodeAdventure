import java.util.HashMap;
import java.util.Map;

class Solution {
    public int titleToNumber(String s) {

        char[] list = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        map.put('A',1);
        map.put('B',2);
        map.put('C',3);
        map.put('D',4);
        map.put('E',5);
        map.put('F',6);
        map.put('G',7);
        map.put('H',8);
        map.put('I',9);
        map.put('J',10);
        map.put('K',11);map.put('S',19);
        map.put('L',12);map.put('T',20);
        map.put('M',13);map.put('U',21);
        map.put('N',14);map.put('V',22);
        map.put('O',15);map.put('W',23);
        map.put('P',16);map.put('X',24);
        map.put('Q',17);map.put('Y',25);
        map.put('R',18);map.put('Z',26);

        int answer = 0;

        if(s==null||s.equals("")){
            return 0;
        }

        int power=0;
        for(int i = list.length-1;i>=0;--i){
            answer += map.get(list[i]) * Math.pow(26,power++);
        }

        return answer;
    }
}