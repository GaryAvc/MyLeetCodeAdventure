public class InsertionSort {

    public static int[] insertionSort(int[] inp){

        int[] oup = new int[inp.length];

        // --- my solution ---
//        for(int i =2;i<inp.length;i++){
//
//            int val = inp[i];
//            int j;
//            for(j=i;j>0;j--){
//                int pre = j-1;
//                if(inp[pre] > val){
//                    inp[j] = inp[pre];
//                }else{
//                    break;
//                }
//            }
//
//            inp[j] = val;
//        }


//         professor's pseudocode
        for( int j=1;j<inp.length;j++){
            int key = inp[j];
            int i =j-1;
            while(i>=0 && inp[i]>key){

                inp[i+1] = inp[i];
                i=i-1;
            }
            inp[i+1] = key;
        }

//        {
//            int n = inp.length;
//            for (int i = 1; i < n; ++i) {
//                int key = inp[i];
//                int j = i - 1;
//
//            /* Move elements of inp[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//                while (j >= 0 && inp[j] > key) {
//                    inp[j + 1] = inp[j];
//                    j = j - 1;
//                }
//                inp[j + 1] = key;
//            }
//        }

        return inp;

    }

    public static void main(String[] args) {
        int[] test = {8,5,2,7,9};
        test = insertionSort(test);
        for(int x :test){
            System.out.print(x + " ");
        }
    }
}
