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
     * 79. Word Search - Change this to recursive solution
     *  TODO - Complete Leetcode
     * Complete it in leetcode - CHANGE THIS TO RECURSION
     *
     */
    boolean wordFound(String word,char[][] board, int i , int j) {

        int rowLength = board.length - 1;
        int colLength = board[0].length - 1;


        for(int k = 1; k < word.length(); k++) {

            if(i <= rowLength && j <= colLength) {

                if(board[i][j + 1] == word.charAt(k)  || board[i - 1][j] == word.charAt(k)
                        || board[i + 1][j]== word.charAt(k)
                        || board[i][j - 1] == word.charAt(k))

                {
                    continue;
                }
                else {
                    return false;
                }
            }}
        return true;

    }


/**
 * 73. Set Matrix Zeroes TODO Complete Leetcode
 */
}


