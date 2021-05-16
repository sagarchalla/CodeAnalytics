package leet.code.algorithms.sorrting.algorithms;



public class BubbleSortAlgorithm {


    /**
     * Bubble sort
     * Algorithm to sort arrays
     * @param integerArray
     */
    // Bubble sort with optimization
    private static void optimizedBubbleSort( int[] integerArray) {

        boolean swapped = true;
        int j = 0;


        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < integerArray.length - j; i++) {
                if (integerArray[i] < integerArray[i + 1]) {
                    int temp = integerArray[i];
                    integerArray[i] = integerArray[i + 1];
                    integerArray[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] integerArray = {21,56, 54, 45, 2, 5, 46};
        int j = 0;

        optimizedBubbleSort(integerArray);

        // Print sorted array
        for( int i = 0; i < integerArray.length ; i++ ) {
            j++;
            System.out.println(" Sorted Array Element At " + j   + " " + integerArray[i] + " ");
        }

     }

}
