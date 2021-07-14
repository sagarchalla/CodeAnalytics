package grokking.java;

// Cyclic Sort
public class PatternCyclicSort {

    // Input: [3, 1, 5, 4, 2]
    static int[] sort(int[] nums) {
      int i = 0;
      while(i < nums.length) {
       int digit = nums[i] - 1;
        if(digit != i) {
        int temp = nums[digit];
        nums[digit] = digit + 1;
        nums[i] = temp;

       }
        else {
          i++;
        }

      }
   return nums;
    }



    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}


