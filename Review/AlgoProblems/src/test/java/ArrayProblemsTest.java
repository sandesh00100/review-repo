import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayProblemsTest {
    ArrayProblems arrayProblems = new ArrayProblems();

    @Test
    public void checkIfUniqueTest() {
        String uniqueChars = "abcd";
        String notUnique = "aabc";
        assert (arrayProblems.checkIfUnique(uniqueChars));
        assert (!arrayProblems.checkIfUnique(notUnique));
    }

    @Test
    public void checkIfUniqueWithoutSortTest() {
        String uniqueChars = "abcd";
        String notUnique = "aabc";
        assert (arrayProblems.checkIfUniqueWithoutSort(uniqueChars));
        assert (!arrayProblems.checkIfUniqueWithoutSort(notUnique));
    }

    @Test
    public void checkForPermutationTest() {
        String s1 = "abcdefg";
        String s2 = "gfdebca";
        String s3 = "bdsefas";
        assert (arrayProblems.checkForPermutation(s1, s2));
        assert (!arrayProblems.checkForPermutation(s1, s3));
    }

    @Test
    public void urilifyTest() {
        String input = "Mr John Smith        ";
        int strSize = 13;
        String urilifiedExpected = "Mr%20John%20Smith";
        String urilifiedOutput = arrayProblems.urilify(input, strSize);
        assert (urilifiedExpected.equals(urilifiedOutput));
    }

    @Test
    public void plaindromePermutationTest() {
        assert (arrayProblems.palindromePermutation("Tact Coa"));
        assert (!arrayProblems.palindromePermutation("TactbCoa"));
        assert (arrayProblems.palindromePermutation("a"));
    }

    @Test
    public void oneWayTest() {
        assert (arrayProblems.oneAway("abcd", "abc"));
        assert (arrayProblems.oneAway("abcd", "ebcd"));
        assert (arrayProblems.oneAway("abcd", "abcdd"));
    }

    @Test
    public void compressedStringTest() {
        assert (arrayProblems.stringCompression("aaabccdddd").equals("a3b1c2d4"));
        assert (arrayProblems.stringCompression("abcde").equals("abcde"));
    }

    @Test
    public void rotateMatrixTest() {
        int[][] orignalMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] expectedRotatedMatrix = {
                {4,8,12},
                {3,7,11},
                {2,6,10},
                {1,5,9}
        };
        int[][] outputRotatedMatrix = arrayProblems.rotateMatrix(orignalMatrix);

        for (int i=0; i<outputRotatedMatrix.length; i++){
            for(int j=0; j<outputRotatedMatrix[0].length; j++){
                if (outputRotatedMatrix[i][j] != expectedRotatedMatrix[i][j]){
                    assert(false);
                }
            }
        }
        assert(true);

    }
}
