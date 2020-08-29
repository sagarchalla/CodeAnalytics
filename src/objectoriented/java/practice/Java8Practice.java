package objectoriented.java.practice;

import java.util.Arrays;

public class Java8Practice {

    // Practice java 8 problems
    void howLambdasWork() {

        int[] nums = new int[5];

        int[] resultArray = new int[nums.length];


        Arrays.stream(nums).forEach( i -> {
            int count = 0;
            while(i != 0 || i!= 1) {
                int remainder = i%2;
                i = i/2;
                if (remainder == 1)
                    count++;

            }

        });


    }
}
