package random.interview.problems;

public class BitManipuation {


    // Find if two hexadecimal numbers are consecutive in gray code
    public static void main(String[] args) {

        byte b1 = 0;
        byte b2 = 0;
     findIfConcescutiveGreyCode( b1,  b2);

    }

    static void findIfConcescutiveGreyCode(byte b1, byte b2) {

        byte result = (byte)(b1 ^ b2);

        int total = 0;

        while(result != 0) {
            result = (byte)(result & (result -1));
            result++;
        }

        if(result == 1) {
            // retur 1;
        }
        else {
            // return 0;
        }

    }


}
