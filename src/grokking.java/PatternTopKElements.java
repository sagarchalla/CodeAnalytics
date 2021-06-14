package grokking.java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PatternTopKElements {


    static List<Integer> findKLargestNumbers(int[] numbers, int k) {

        // solve using min heap method
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // create min heap
        for (int i = 0; i < k; i++) {
            priorityQueue.add(numbers[i]);
        }

        // make the heap with the three largest numbers
        for (int j = k; j < numbers.length; j++) {
            if (numbers[j] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(numbers[j]);
            }

        }

        return new ArrayList<>(priorityQueue);

    }


    public static void main(String[] args) {
        List<Integer> result = findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}

