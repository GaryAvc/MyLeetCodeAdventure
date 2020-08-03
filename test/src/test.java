public class test {

    public static void main(String[] args) {

        int[]y = {0,1,2,3};
        for(int i:y){
            System.out.println(i);
        }

        changy(y);
        for(int i:y){
            System.out.println(i);
        }


        int x =100;
        System.out.println(x);
        change(x);
        System.out.println(x);
        x=changereturn(x);
        System.out.println(x);
    }

    public static void changy (int[] y){
        y[0]=100;
    }

    public static void change (int x ){
        x=20;
    }

    public static int changereturn (int x ){
        x=20;
        return x;
    }

}
