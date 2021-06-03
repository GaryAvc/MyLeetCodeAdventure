public class backInsertionSort {

    public static int[] backInsertionSort(int [] A, int n){

        for( int i=1;i<n;i++){
            int key = A[i];
            int j =0;

            while(j<i && A[j] < A[i]){
                j=j+1;
            }

            for( int x = i-1;x>=j;x--){
                A[x+1]=A[x];
            }

            A[j] = key;
        }


        return A;
    }

    public static void main(String[] args) {
//        int [] A = {8,5,7,2,3};
//        backInsertionSort(A,A.length);
//        for(int i : A){
//            System.out.print(i + " ");
//        }
        System.out.println(-3.5%2);
    }
}
