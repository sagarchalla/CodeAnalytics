package algoritms.misc.practice.whiteboard.search.algorithms;


import java.util.Scanner;

/**
 * Recursive binary search implementation
 * <p>
 * call the same method and minimize the
 * array size until reaching the target
 */
public class BinarySearchRecursive {

    private static int binarySearch(int target, int startindex, int endIndex, int[] integerArray) {


        if (startindex <= endIndex) {

            // calculate the median
            int midIndex = startindex + (endIndex - startindex) / 2;

            // median is the target
            if (integerArray[midIndex] == target)
                return midIndex;

            // if median greater than the target, right elements can be ignored
                   if (integerArray[midIndex] > target)
                return binarySearch(target, startindex, midIndex - 1, integerArray);

            // if the median is less than the target, left elements can be ignored
            return binarySearch(target, midIndex + 1, endIndex, integerArray);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] integerArray = {2, 32, 45, 67, 88, 90, 234};

        int startIndex = 0;
        int arrayLength = integerArray.length;
        int endIndex = arrayLength - 1;

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();


        long startTime = System.nanoTime();

        int index = binarySearch(target, startIndex, endIndex, integerArray);

        long executionTime = System.nanoTime() - startTime;

        // print output
        System.out.println("The element found at index : " + index + " in time " + executionTime) ;
    }
}
