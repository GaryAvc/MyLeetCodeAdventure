public class Solution {
    public static int[]  selections( int [] x){

        int count=0;
        int [] answer = new int[x.length];

        for( int i =0;i<x.length;i++){

            int min = x[i];
            int minIndex = i;
            for(int j =i;j<x.length;j++){
                if(x[j]<min){
                    min = x[j];
                    minIndex = j;
                }
            }
//            if(minIndex!= i){
                int temp = x[i];
                x[i] = min;
                x[minIndex] = temp;
                count++;
//            }

        }
        answer = x;
        System.out.println("count: "+ count);
        return answer;
    }

    public static void main(String[] args) {v

        int [] test = {3,7,2,9,10,5};
        int [] test1 = {8,5,2,7,9};
        test = selections(test);
        for(int i : test){
            System.out.print( i  + " ");
        }
    }
}
