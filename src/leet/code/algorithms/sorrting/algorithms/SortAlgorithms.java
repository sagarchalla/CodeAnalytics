package leet.code.algorithms.sorrting.algorithms;

public class SortAlgorithms {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 2, 51, 3, 1};
     System.out.println(bubbleSort(nums));
    }

    static int[] bubbleSort(int[] nums) {

        boolean isSorted;
        for (int i = 0; i < nums.length - 1; i++) {
            isSorted = true;

            for (int j = 1; j < nums.length - i; j++) {

                if (nums[i] < nums[j]) {
                    // swap method here

                    isSorted = false;
                }

            }
            if (isSorted) {
                return nums;
            }
        }
        return nums;
    }


    static int[] insertionSort(int[] nums) {


        // loop

        // compare i + 1

        // if less shif the left array

        int i = 1;
        while(i < nums.length);
        for(int j = 0; j < i; j++) {
            if(nums[j] > nums[i]) {
                 int temp =  nums[j];
                 nums[i] = nums[j];
                 nums[j] = temp;
            }
        }
        i++;


        return nums;
    }

    static int[] mergeSort(int[] nums) {
        return nums;
    }
}
