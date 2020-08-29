package chapter1.arrays;

public class TwoDimensionalArrays {


    public static void main(String[] args) {

    }

    static void findWordIn2DimArray(char[][] board, String word) {


        for(int i = 0; i < board.length; i++) {
            for(int j=0; j< board[i].length; j++) {


                for(int k = 0; k< word.length(); k++) {

                    if(board[i][j] == word.charAt(k)) {

                        // algorithm check now



                    }

                }
            }
        }


    }

}
