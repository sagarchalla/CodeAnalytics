package grokking.java;

// Cyclic Sort
public class PatternCyclicSort {

    // 2 6 4 3 1 5
    public static void sort(int[] nums) {

        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                // swap
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
            else
                i++;
        }

    }


    public static void main(String[] args) {
        System.out.println();
    }

}
