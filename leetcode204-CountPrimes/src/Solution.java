import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
//    public int countPrimes(int n) {
//
//        int answer = 0;
//        if(n<=1){
//            return answer;
//        }
//
//        for(int i=2;i<n;++i){
//            if(helper(i)){
//                answer++;
//            }
//        }
//        return answer;
//    }
//
//    public boolean helper(int n){
//
//        for(int i = 2;i<=n/2;++i){
//            if(n%i==0){
//                return false;
//            }
//        }
//
//        return true;
//    }

//    pre-work
    public int countPrimes(int n) {
        int answer = 0;

        if(n<=1){
            return 0;
        }
        int[] isprime = new int[n+1];
        Arrays.fill(isprime,1);

        for(int i=2;i*i<=n;++i){
            if(isprime[i]==1){
                for(int j=i*i;j<n;j+=i){
                    isprime[j]=0;
                }
            }
        }

        for(int i =2;i<=n;++i){
            if(isprime[i]==1){
                ++answer;
            }
        }

        return --answer;
    }

}