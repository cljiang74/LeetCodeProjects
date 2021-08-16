package crackcoding;
import org.junit.jupiter.api.Test;

import static crackcoding.Chapter1.*;
import static org.junit.jupiter.api.Assertions.*;

class Chapter1Test {

    @Test
    void testIsUnique() {
        String valid = "Helium";
        String invalid = "Hello";
        assertTrue(isUnique(valid));
        assertFalse(isUnique(invalid));
    }

    @Test
    void testIsPermutation() {
        String str1 = "Apple";
        String str2 = "ppAle";
        assertTrue(isPermutation(str1, str2));
    }

    @Test
    void testChangeSpaceToChar() {
        String origStr = "Mr John Smith    ";
        String expRes = "Mr%20John%20Smith";
        char[] str = origStr.toCharArray();
        int trueLength = 13;
        changeSpaceToChar(str, trueLength);
        assertEquals(str, expRes.toCharArray());
    }

    @Test
    void testIsPermPalindrome() {
        String palindrome = "Tact Coa";
        String notPalin = "Tact";
        assertTrue(isPermPalindrome(palindrome));
        assertFalse(isPermPalindrome(notPalin));
    }

    @Test
    void testOneAway() {
        String str1 = "pale";
        String str2 = "bale";
        String str3 = "bake";

        assertTrue(oneAway(str1, str2));
        assertFalse(oneAway(str1, str3));
    }

    @Test
    void testStrCompression() {
        String str = "aaabbbbbcccccc";
        String exp = "a3b5c6";
        assertEquals(exp, strCompression(str));
    }

    @Test
    void testRotateMatrix() {
        int[][] mat= new int[][]{{5, 1, 9, 11},
                                 {2, 4, 8, 10},
                                 {13,3, 6, 7},
                                 {15,14,12,16}};
        int[][] exp = new int[][] {{15,13,2,5},
                                   {14,3, 4,1},
                                   {12,6, 8,9},
                                   {16,7,10,11}};
        rotateMatrix(mat);
        for(int i=0; i<exp.length; i++) {
            for(int j=0; j<exp[0].length; j++) {
                assertEquals(mat[i][j],exp[i][j]);
            }
        }
    }

    @Test
    void testZeroMatrix(){
        int[][] mat= new int[][]{{0, 1, 9, 11},
                {2, 0, 8, 10},
                {13,3, 0, 7},
                {15,14,12,0}};
        zeroMatrix(mat);
        for(int[] r: mat)
            for(int i: r)
                assertEquals(0, i);
    }

    @Test
    void testIsSubstring() {
        String s1 = "String";
        String s2 = "ring";
        String s3 = "ringo";
        assertTrue(isSubstring(s1, s2));
        assertFalse(isSubstring(s1, s3));
    }

    @Test
    void testStrRotate() {
        String s1 = "watermelon";
        String s2 = "lonwaterme";
        String s3 = "nolwaterme";
        assertTrue(strRotate(s1, s2));
        assertFalse(strRotate(s1, s3));
    }

}