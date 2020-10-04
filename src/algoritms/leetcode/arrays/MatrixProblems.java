package algoritms.leetcode.arrays;

import java.util.List;

// Also known as two dimensional problems
public class MatrixProblems {

    public static void main(String[] args) {
        int[][] spiralMatrix = {{1, 2, 3, 4, 5},
                {11,22,33,44,55},
                {5, 4, 0, 2, 1},
                {55,44,33,22,11},
                {6, 7, 8, 9, 22}};

        spiralOrder(spiralMatrix);
    }


    static List<Integer> spiralOrder(int[][] matrix) {

        int left = 0; int right = matrix[0].length - 1;
        int top = 0; int bottom = matrix.length - 1;

        // left to right
        for (int i = left; i <= right; i++) {
            System.out.println(matrix[left][i]);
        }

        // top to bottom
        for (int i = top; i <= bottom; i++) {
            System.out.println(matrix[i][bottom]);
        }

        // right to left
        for(int i = right; i >= left; i--){
            System.out.println(matrix[left][i]);
        }

        // bottom to top
        for(int i = bottom; i >= top; i--) {
            System.out.println(matrix[i][top]);
        }
        return null;
    }



}
