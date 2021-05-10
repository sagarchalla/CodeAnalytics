package grokking.coding.interview;

// pattern 1 sliding window
public class SlidingWindow {

    // 0 , 1 , 3 , 5 , 6 // k = 2

    // problem - max contiguous sub array of size 3
    int getMaxSubArray(int[] array, int k){
        int maxSum = 0 , windowSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
            windowSum += array[windowEnd];
            if(windowEnd >= k - 1){
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= array[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    // [2, 1, 5, 2, 3, 2], S=7
    // Smallest Subarray with a given sum
    int smallestSubArray(int[] array, int k){
        int windowSum = 0 , length = Integer.MAX_VALUE , windowStart = 0;
        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
            windowSum += array[windowEnd];
            while(windowSum >= k){ // need to shrink the window as small as possible
                length = Math.min(length , windowEnd - windowStart + 1);
                windowSum -= array[windowStart];
                windowStart++;
            }
        }
        return -1;
    }

    int kDistinctCharacters(int[] array , int k) {
            return 0;
    }
}
