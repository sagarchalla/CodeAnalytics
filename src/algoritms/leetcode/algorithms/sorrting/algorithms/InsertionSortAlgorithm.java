package algoritms.leetcode.algorithms.sorrting.algorithms;


/**
 * Insertion Sort
 */
public class InsertionSortAlgorithm {

    private static int[] performInsertionSort(int[] integerArray) {

        int i;
        int key;                // the item to be inserted
        int j;
        // 2 loops needed
        for ( i = 1; i < integerArray.length; i++) {

            // store the key value
             key = integerArray[i];

            // move smaller values to the right
            for ( j = i - 1; j >= 0 && integerArray[j] < key; j--) {

                // place the smaller value in the next position
                integerArray[j + 1] = integerArray[j];
            }

            // place the key in its proper location
            integerArray[j + 1] = key;
        }
    return integerArray;
    }

    public static void main(String[] args) {

        int[] integerArray = {21,56, 54, 45, 2, 5, 46};
        int j = 0;

        performInsertionSort(integerArray);

        // Print sorted array
        for( int i = 0; i < integerArray.length ; i++ ) {
            j++;
            System.out.println(" Sorted Array Element At " + j   + " " + integerArray[i] + " ");
        }


    }
}
