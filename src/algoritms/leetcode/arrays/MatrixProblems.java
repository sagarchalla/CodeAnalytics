package algoritms.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

// Also known as two dimensional problems
public class MatrixProblems {

    public static void main(String[] args) {
        int[][] spiralMatrix = {{1, 2, 3, 4, 5},
                {11,22,33,44,55},
                {5, 4, 0, 2, 1},
                {55,44,33,22,11},
                {6, 7, 8, 9, 22}};

        spiralOrder(spiralMatrix).stream().forEach(i -> System.out.println(i));
    }

    // TODO fix the code here
    static List<Integer> spiralOrder(int[][] matrix) {

        int left = 0; int right = matrix[0].length - 1;
        int top = 0; int bottom = matrix.length - 1;

        String direction = "right";
        List<Integer> resultList = new ArrayList<>();

        while(left <= right && top <= bottom) {
            // left to right
            if(direction.equals("right")) {
                for (int i = left; i <= right; i++) {
                    resultList.add(matrix[left][i]);
                }
                direction = "down";
                top++;
            }
            // top to bottom
            else if(direction.equals("down")) {
            for (int i = top; i <= bottom; i++) {
                resultList.add(matrix[i][bottom]);
            }
            direction = "left";
            left--;
            }

            // right to left
            else if(direction.equals("left")) {
            for (int i = right; i >= left; i--) {
                resultList.add(matrix[right][i]);
            }
            direction = "up";
            bottom--;
            }

            // bottom to top
            else if(direction.equals("up")) {
            for (int i = bottom; i >= top; i--) {
                resultList.add(matrix[i][top]);
            }
            direction = "right";
            left++;
        } }

        return resultList;
    }

    /**
     * 79. Word Search TODO
     */

    /**
     * 73. Set Matrix Zeroes TODO
     */
}


