import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

class Solution {

    ArrayList<Integer> zero = new ArrayList<>();
    ArrayList<Integer> one = new ArrayList<>();
    ArrayList<Integer> two = new ArrayList<>();
    ArrayList<Integer> three = new ArrayList<>();
    ArrayList<Integer> four = new ArrayList<>();
    ArrayList<Integer> five = new ArrayList<>();
    ArrayList<Integer> six = new ArrayList<>();
    ArrayList<Integer> seven = new ArrayList<>();
    ArrayList<Integer> eight = new ArrayList<>();
    ArrayList<Integer> nine = new ArrayList<>();

    /*
    Invariance:
        1. we iterate the whole array, and get the nums with the same start number
        2. we check the nums with  the same start num, if the second digit is different then push it into string,
        3. we divide the num into 2 parts, the first part is the same part, the second part is the diffreent part
        4. if the same part is the last digit, continuously, use the same part as the different part for comparation until one digit is different
            {e.g 3456 - 34563459 'same-3456' keep compare '34563456 - 34563459' we see that 34563459 is larger}
     */
    public String largestNumber(int[] nums) {

        String answer = "";

        // loop the nums array
        for(int i =0;i<nums.length;i++){
            switch (xDigit(0, nums[i])){
                case 0: zero.add(nums[i]);break;
                case 1: one.add(nums[i]);break;
                case 2: two.add(nums[i]);break;
                case 3: three.add(nums[i]);break;
                case 4: four.add(nums[i]);break;
                case 5: five.add(nums[i]);break;
                case 6: six.add(nums[i]);break;
                case 7: seven.add(nums[i]);break;
                case 8: eight.add(nums[i]);break;
                case 9: nine.add(nums[i]);break;
                default:break;
            }
        }


        return answer;
    }

    // return the value of digit at x index
    private int xDigit(int index,int num){
        String s = String.valueOf(num);
        s=s.substring(index,index+1);
        return Integer.parseInt(s);
    }

    // this function take in the array of nums that has the same first digit and push the every nums into answer String in order
    private void pushArray(ArrayList<Integer> arrayList){

    }
}