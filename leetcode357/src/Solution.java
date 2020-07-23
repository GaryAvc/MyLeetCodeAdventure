class Solution {

    static boolean uniqueNumber = true;

    public int countNumbersWithUniqueDigits(int n) {

        if(n==0){
            return 1;
        }
        int x = (int)Math.pow(10,n);
        int notUniqueNum=0;

        for(int i=0;i<x;i++){
            int lastDigit = i%10;
            int startNum = i/10;

            checkUnique(startNum,lastDigit);
            if(!uniqueNumber){
                notUniqueNum+=1;
            }
        }
        return x-notUniqueNum;

    }

    public static void checkUnique(int x,int lastDigit){
        if(x==0){
            return;
        }

        int newLastDigit = x%10;
        if(newLastDigit != lastDigit){
            uniqueNumber = true;
        }else{
            uniqueNumber = false;
        }
        x=x/10;
        checkUnique(x,newLastDigit);
    }
}