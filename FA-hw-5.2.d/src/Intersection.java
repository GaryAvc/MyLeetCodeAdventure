public class Intersection {


    public static void main(String[] args) {

        int [] a ={1,2,3,4,5,16};
        int [] b ={6,7,8,9,10,11,12,13,14,15,16};


        System.out.println( intersect(0,0,a,b));



    }

    public static boolean intersect( int i, int j, int [] a, int [] b){




        //base case:
        if( j == b.length){
            return true;
        }else if( i<a.length-1 && a[i] < b[j]) {

            return intersect(i + 1, j, a, b);
        }
        else if (i==a.length-1 && a[i] < b[j]){
            return true;
        }
        else if (a[i] > b[j]){
            return intersect(i,j+1,a,b);
        }else{
            return false;
        }

    }
}
