package grokking.java;

// Cyclic Sort
public class PatternFive {


    // problem cyclic sort // time complexity o(n) + o(n - 1) = o(n) // constant space
    public static void sort(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(nums[i] - 1 != i){
                // swap
                int temp = nums[i];
                nums[temp] = nums[i];
                nums[i] = temp;
            }
            else {
                i++;
            }
        }
    }

}
