import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    static List<Integer>  sorted = new LinkedList<>();

    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");

        for( int x : sorted){
            System.out.print(x + " ");
        }
    }


    /*
        Invariance:
        1. this merge function will only be called when it reach the end of both left and right
        2. as above, the
     */
    void merge(int arr[], int l, int m, int r) {




        for(int i =sorted.size();i<=r;i++){

            int unsortedNum = arr[i];
            for( int j=0;j<sorted.size();j++){
                int sortedNum = arr[j];
                if(unsortedNum < sortedNum ){
                    sorted.add(j,unsortedNum);
                    break;
                }
            }
        }

    }


    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
