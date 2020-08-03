public class midtermCombine6 {

    static class Comfunc{
        public int apply(int a,int b){
            return a+b;
        }
    }

    public static void main(String[] args) {
        Comfunc f = new Comfunc();
        int[]x={1,2,3,4};
        System.out.println(combine(f,x));
    }

    public static int combine(Comfunc f,int[]x){
        int answer = helper(f,x);
        return answer;
    }

    private static int helper(Comfunc f, int[] x) {
        int result = x[0];
        for(int i=1;i<x.length;++i){
            result=f.apply(result,x[i]);
        }
        return result;
    }
}
