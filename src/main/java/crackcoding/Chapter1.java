package crackcoding;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Contains solution to CCI book
 */
public class Chapter1 {

    public static boolean isUnique(String candi) {
        Set<Character> candiChars = new HashSet<>();
        for(char c: candi.toCharArray()) {
            if(candiChars.contains(c))
                return false;
            candiChars.add(c);
        }
        return true;
    }

    public static boolean isPermutation(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        Map<Character, Integer> wordFreq1 = new HashMap<>(), wordFreq2 = new HashMap<>();
        for(char c: str1.toCharArray())
            wordFreq1.put(c,wordFreq1.getOrDefault(c, 0));
        for(char c: str2.toCharArray())
            wordFreq2.put(c,wordFreq2.getOrDefault(c, 0));
        return wordFreq1.equals(wordFreq2);
    }

    public static void changeSpaceToChar(char[] str, int trueLength) {
        for(int i=0; i<str.length; i++) {
            if(str[i] == ' ') {
                for(int j=trueLength-1; j>=i+1; j--)
                    str[j+2] = str[j];
                str[i] = '%';
                str[i+1] = '2';
                str[i+2] = '0';
            }
        }
    }

    public static boolean isPermPalindrome(String str) {
        Map<Character, Integer> wordFreq = new HashMap<>();
        int singleCtr = 0;
        for(char c: str.toLowerCase().toCharArray()) {
            if (!Character.isWhitespace(c))
                wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
        }
        for(int freq: wordFreq.values()) {
            if(freq % 2 != 0)
                singleCtr++;
            if(singleCtr > 1)
                return false;
        }
        return true;
    }

    public static boolean oneAway(String str1, String str2) {
        int diff = Math.abs(str1.length()-str2.length());
        if(diff >= 2 || str1.equals(str2)) return false;
        // sort strings
        String st = str1.length() >= str2.length()? str2 : str1;
        String lg = str1.length() >= str2.length()? str1 : str2;
        int i = 0, j = 0;
        boolean difference = false;
        while(i < st.length() && j < lg.length()) {
            if(st.charAt(i) != lg.charAt(j)) {
                if(difference)
                    return false;
                difference = true;
                if(st.length() == lg.length())
                    i++; //On replace, move shorter pointer
            }
            else
                i++;
            j++;
        }
        return true;
    }

    public static String strCompression(String str) {
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < str.length()) {
            int ctr = 0;
            char curt = str.charAt(i);
            while(i < str.length() && str.charAt(i) == curt) {
                ctr++;
                i++;
            }
            res.append(curt);
            res.append(ctr);
        }
        return res.length() > str.length()? str:res.toString();
    }

    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int cirLeng = matrix.length - 1;
        // starting from the out-most loop
        // rotate one pixel starting from the corner in four orientations
        // loop to the next inner circle until the middle
        // so totally will loop n/2 times
        for(int i=0; i < n/2; i++) {
            int startpt = i;
            int endpt = cirLeng - i;
            for (int j = 0; j < endpt - startpt; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[endpt - j][i];
                matrix[endpt - j][i] = matrix[endpt][endpt - j];
                matrix[endpt][endpt - j] = matrix[i + j][endpt];
                matrix[i + j][endpt] = temp;
            }
        }
    }

    public static void zeroMatrix(int[][] matrix) {
        Set<Integer> row = new HashSet<>(), col = new HashSet<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int r: row)
            for(int j=0; j<matrix[0].length; j++)
                matrix[r][j] = 0;
        for(int c: col)
            for(int j=0; j<matrix.length; j++)
                matrix[j][c] = 0;
    }

    public static boolean strRotate(String s1, String s2) {
        // check if s2 is a rotation of s1 using only one
        // call to isSubstring
        if(s1.length() != s2.length()) return false;
        return isSubstring(s1+s1, s2);
    }

    public static boolean isSubstring(String s1, String s2) {
        // return true if s2 is substring of s1
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)) {
                int j = 0;
                while(j<s2.length()) {
                    if(i >= s1.length() || s1.charAt(i) != s2.charAt(j))
                        return false;
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
}
