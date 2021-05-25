package grokking.java;

import java.util.Arrays;

public class PatternTwoPointers {

    // pair with target sum
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == targetSum){
                return new int[]{arr[left] , arr[right]};
            }
            else if(sum > targetSum){
                right--;
            }
            else {
                left++;
            }
        }
       return new int[] { -1, -1 };
    }

    // remove duplicates //
    public static int remove(int[] arr) {
     return 0;
    }

    // triplet sum close to target // Input: [-2, 0, 1, 2],
    public static int searchTriplets(int[] arr, int target) {

        int min = Integer.MAX_VALUE;


        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1; int right = arr.length - 1;
            while(left < right){
                int targetSum = arr[i] + arr[left] + arr[right];

                if(targetSum == target){
                    // closest sum found return it
                    return targetSum;
                }

                else if(targetSum < target){
                    left++;
                }
                else {
                    right--;
                }
                min = Math.abs(min)>Math.abs(target-targetSum)?target-targetSum:min;
            }
        }
        return target - min;

    }

    // triplets with smaller sum //Input: [-1, 1, 2, 3, 4], target = 5
    public static int smallerSumTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int tripletCount = 0;
        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1; int right = arr.length - 1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum < target){
                    tripletCount += 1;
                    left++;
                }else {
                    right--;
                }
            }

        }
       return tripletCount;
    }



    // squaring a sorted array
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

         return squares;
    }


    public static void main(String[] args) {
       /* int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");*/
/*
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(remove(arr));*/

        System.out.println(smallerSumTriplets(new int[] { -1, 0, 2, 3 }, 3));
       // System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
