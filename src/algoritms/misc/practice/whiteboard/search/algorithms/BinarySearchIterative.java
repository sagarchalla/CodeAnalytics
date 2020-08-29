package algoritms.misc.practice.whiteboard.search.algorithms;


import java.util.Scanner;

/**
 * Iterative binary search implementation
 *
 */
public class BinarySearchIterative {


    private static int binarySearch(int[] integerArray, int startIndex, int endIndex, int target) {

        while(startIndex <= endIndex) {

        int median = startIndex + (endIndex - startIndex)/2;

        if(integerArray[median] ==  target)
            return median;

        // ignore the left array
        if(integerArray[median] < target)
            startIndex = median + 1;


        else
            endIndex = median - 1;

        }
    return  -1;
    }


    public static void main(String[] args) {

        int[] integerArray = {2, 32, 45, 67, 88, 90, 234};

        // int findIndex = 90;
        int startIndex = 0;
        int arrayLength = integerArray.length;
        int endIndex = arrayLength - 1;

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();


        int index = binarySearch(integerArray, startIndex, endIndex, target);


        // print output
        System.out.println("The element found at index : " + index + " in time " ) ;
    }


}