package algoritms.misc.practice.whiteboard.sorrting.algorithms;


/**
 * Create two recursive merge sorts
 *
 * Combine two sorted arrays
 *
 */
public class MergeSortAlgorithm {


    private static void splitArrays() {

       // create two arrays
        int[] integerArray = {24,2,3,56,78,64,34,78,95};

        int median = (integerArray.length) /2;

        // splitting arrays
        int[] splitArray1 = new int[median];

        int[] splitArray2 = new int[integerArray.length - median];

        for(int i=0; i < median; i++){
            splitArray1[i] = integerArray[i];
        }

        int j =0;
        for(int i=median; i < integerArray.length; i++){
             splitArray2[j] = integerArray[i];
             j++;
         }


        // spot check to see if all are right
        for(int i=0; i < splitArray1.length; i++){
            System.out.println( "splitarray1 " + splitArray1[i]);
        }

        for(int i=0; i < splitArray2.length; i++){
            System.out.println( "splitArray2 " + splitArray2[i]);
        }

    }


    private static void mergeSorts(int[] array, int firstIndex, int lastIndex) {
        if(firstIndex >= lastIndex) {
            return;
        }
        int median = (firstIndex + lastIndex) /2;

        mergeSorts(array, firstIndex, median);
        mergeSorts(array, median + 1, lastIndex);


    }


    public static void main(String[] args) {
        int[] array = {22,2,33};

        int firstIndex = 0;

        int lastIndex = array.length - 1;

        mergeSorts(array,firstIndex,lastIndex);

    }

}
