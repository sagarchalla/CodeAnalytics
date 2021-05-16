package leet.code.arrays;

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

    /**
     * 10. Walls and Gates
     * Leetcode: Premium Problem // similar to Number of Islands // word search
     */
    static int[][] wallsAndGates(int[][] matrix){
        // traverse though the matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j<matrix[i].length; i++){
                if(matrix[i][j] == 0){
                    // depth first search
                    dfs(i , j , matrix, 0);
                }
            }
        }
      return matrix;
    }
    // helper method here
    static void dfs(int row, int col, int[][] matrix, int count){

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length || matrix[row][col] > count){
            return;
        }
        matrix[row][col] = count;
        dfs(row + 1, col, matrix, count + 1);
        dfs(row, col + 1, matrix, count + 1);
        dfs(row - 1, col, matrix, count + 1);
        dfs(row, col - 1, matrix, count + 1);
    }


    /**
     * 79. Word Search
     *
     */
   /* boolean wordFound(String word,char[][] board, int i , int j) {

    }*/





    /**
     * 54. Spiral Matrix
     * Leetcode: Completed
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();


        if(matrix.length == 0) {
            return result;
        }

        int rowBegin = 0; int rowEnd = matrix.length - 1;
        int colBegin = 0; int colEnd = matrix[0].length - 1;



        String direction = "right";
        while(rowBegin <= rowEnd && colBegin <= colEnd) {

            if(direction.equals("right")) {

                for(int i = colBegin; i <= colEnd; i++) {
                    result.add(matrix[rowBegin][i]);
                }
                direction = "down";
                rowBegin++;
            }

            else if(direction.equals("down")) {

                for(int i = rowBegin; i <= rowEnd; i++) {
                    result.add(matrix[i][colEnd]);
                }
                direction = "left";
                colEnd--;
            }
            else if(direction.equals("left")) {

                for(int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                direction = "up";
                rowEnd--;
            }
            else if(direction.equals("up")) {

                for(int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
                direction = "right";
                colBegin++;
            }
        }
        return result;
    }

/**
 * 73. Set Matrix Zeroes TODO Complete Leetcode
 */
}


