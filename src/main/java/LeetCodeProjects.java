import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This Class contains solution accepted on the LeetCode website
 *
 * @author Leon Jiang
 */
public class LeetCodeProjects {
    private static LeetCodeProjects tester;

    /**
     * Driver class
     *
     * @param args
     */
    public static void main(String[] args) {
        tester = new LeetCodeProjects();

        // Testing reverse()
        int origDig = 12345;
        System.out.println("Starting testing reverse(): \nX has the value of: " + origDig);
        System.out.println("Result after reservation is: " + tester.reverse(origDig));

    }

    /**
     * This method reverse the digits of an Integer
     *
     * @param x the original integer
     * @return  The reversed-digit integer
     */
    public int reverse(int x) {
        int sign = 1;
        long result = 0;
        List<Integer> digits = new ArrayList<>();
        int digit;
        if(x < 0) {
            sign = -1;
            x = -x;
        }
        while(x > 0) {
            digit = x % 10;
            if(digit != 0 || digits.size()!=0) {
                digits.add(digit);
            }
            x /= 10;
        }
        Collections.reverse(digits);
        long i = 1;
        for(Integer n: digits) {
            result += n * i;
            i *= 10;
        }
        if(result > Integer.MAX_VALUE ||
                result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result * sign;
    }

    /**
     * This method finds the first unique character in
     * a string and return its index value
     *
     * @param s input String s
     * @return  the position of first unique Character
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> resultMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if (charMap.containsKey(s.charAt(i)))
                charMap.put(s.charAt(i), 100);
            else
                charMap.put(s.charAt(i), i);
        }
        for(Map.Entry<Character, Integer> entry: charMap.entrySet()) {
            if(!entry.getValue().equals(100)) {
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }

        for(int i=0; i<s.length(); i++) {
            if(resultMap.containsKey(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method checks if a String is Palindrome(can fold up)
     *
     * @param s input String
     * @return  true if the input String is Palindrome
     */
    public boolean isPalindrome(String s) {
        List<Character> charList = new ArrayList<>();
        List<Character> compareList = new ArrayList<>();
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c) ||
                    Character.isDigit(c)) {
                charList.add(s.charAt(i));
                compareList.add(s.charAt(i));
            }
        }
        Collections.reverse(charList);
        return compareList.equals(charList);
    }

    /**
     * My ascii to integer function
     *
     * @param s input string
     * @return  the number input string s represents
     */
    public int myAtoi(String s) {
        List<Integer> digits = new ArrayList<>();
        long result = 0;
        int i = 0;
        int sign = 1;

        if (s.length() == 0) {
            return 0;
        }
        char curtChar = s.charAt(0);

        // ignore while space
        while (Character.isWhitespace(curtChar)) {
            if (i == s.length() - 1) {
                return 0;
            }
            i++;
            curtChar = s.charAt(i);
        }

        // read in sign
        if (curtChar == '-' || curtChar == '+') {
            if (curtChar == '-')
                sign = -1;
            if (i == s.length() - 1) {
                return 0;
            }
            i++;
            curtChar = s.charAt(i);
        }
        // read in until non-digit value is read
        for (int j = i; j < s.length(); j++) {
            curtChar = s.charAt(j);
            if (!Character.isDigit(curtChar)) {
                break;
            }
            if (digits.size() == 0 && curtChar == '0') {
                continue;  // do not add leading zeros
            }
            digits.add(Character.getNumericValue(curtChar));
        }

        if (digits.size() > 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        Collections.reverse(digits);
        long unit = 1;
        for (Integer num : digits) {
            result += unit * num;
            if (result * sign > Integer.MAX_VALUE ||
                    result * sign < Integer.MIN_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            unit *= 10;
        }
        return ((int) result * sign);
    }

    /**
     * strStr method to find the starting index of a needle string
     * in a haystack strings
     *
     * see String.indexOf()
     *
     * @param haystack  haystack string(larger string)
     * @param needle    needle string(shorter string)
     * @return          number of the starting index
     *                  -1 if the needle does not exist in the haystack
     */
    public int strStr(String haystack, String needle) {
        for(int i=0; ;i++) {
            for(int j=0; ;j++) {
                if(j==needle.length()) {return i;}
                if(j+i == haystack.length()) {return -1;}
                if(haystack.charAt(i+j) != needle.charAt(j)) {break;}
            }
        }
    }

    /**
     * Method deletes a node in a ListNode list
     *
     * @param node  node to be deleted
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * remove Nth node from the end of a list
     *
     * @param head  head node of the list
     * @param n     number from the end of list
     * @return      the head node of the result list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) throws Exception {
        if(n < 1)   //edge case check
            throw new Exception("n needs to be positive int");
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    /**
     * This method reverse a linked List by given head of the node
     *
     * @param head  head of the list
     * @return      the updated head of the new list
     */
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        // base case
        if(head == null || head.next == null) {
            return head;
        }

        // recursive case
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }

    /**
     * This function merges two sorted lists
     * Two Lists were sorted in a ascending order
     * the result list should maintain the same order
     *
     * @param l1    head of The original list one
     * @param l2    head of the Original list two
     * @return      Head of the newly merged sort list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // help dummy node
        dummy.next = l1;
        ListNode prev = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                ListNode l2Next = l2.next;
                prev.next = l2;
                l2.next = l1;
                prev = l2;
                l1 = prev.next;
                l2 = l2Next;
            } else { //else, shift l1 to the next value
                l1 = l1.next;
                prev = prev.next;
            }
        }
        // check if there are any elements left in l2
        if(l2 != null) {
            prev.next = l2;
        }
        // return the head of the list
        return dummy.next;
    }

    /**
     * This method checks if a linkedList is Palindrome(reverse-equal)
     *
     * @param head  head of the linkedList
     * @return      true if the List is Palindrome
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> valList = new ArrayList<>();
        List<Integer> origList = new ArrayList<>();
        while(head != null) {
            valList.add(head.val);
            origList.add(head.val);
            head = head.next;
        }
        Collections.reverse(valList);
        return (origList.equals(valList));
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    /**
     * Function checks if there is a infinite cycle inside the linkedList
     *
     * @param head  head of the list
     * @return      true if the infinite cycle exists in the linkedList
     */
    public boolean hasCycle(ListNode head) {
        // fast pointer and slow pointer: if they catch-up, there is a linked list:
        // edge case first:
        if(head == null) {
            return false;
        }
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast.next = head;
        slow.next = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * method rotates a image(represented by 2D array)
     *
     * @param matrix    2D array represent an image
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int cirLeng = matrix.length - 1;
        // starting from the outmost loop
        // rotate one pixel starting from the corner in four orientations
        // loop to the next inner circle until the middle
        // so totally will loop n/2 times
        for(int i=0; i < n/2; i++) {
            int startpt = i;
            int endpt = cirLeng - i;
            for(int j = 0; j < endpt-startpt; j++) {
                int temp = matrix[i][i+j];
                matrix[i][i+j] = matrix[endpt-j][i];
                matrix[endpt-j][i] = matrix[endpt][endpt-j];
                matrix[endpt][endpt-j] = matrix[i+j][endpt];
                matrix[i+j][endpt] = temp;
            }
        }
        /** Test Case
         [[5, 1, 9, 11],
         [2, 4, 8, 10],
         [13,3, 6, 7],
         [15,14,12,16]]

         [[15,13,2,5],
         [14,3, 4,1],
         [12,6, 8,9],
         [16,7,10,11]]
         */
    }

    /**
     * This function transfers roman integers to arabic digits
     *
     * @param s original Roman letter string
     * @return  the numerical representation of the string
     *          requires the string to be legit Roman letters
     */
    public int romanToInt(String s) {
        char[] letters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] vals   =   { 1,   5,  10,  50, 100, 500, 1000};
        int result = 0;
        Map<Character, Integer> romanMap = new HashMap<>();
        for(int i=0; i<letters.length; i++) {
            romanMap.put(letters[i], vals[i]);
        }
        List<Character> romans = readStringFromBack(s);
        for(int i=0; i<romans.size(); i++) {
            if(i == romans.size()  - 1) {   // edge case
                result += romanMap.get(romans.get(i));
                break;
            }
            int prev = romanMap.get(romans.get(i+1));
            int curt = romanMap.get(romans.get(i));
            if(prev < curt) {
                result +=curt;
                result -= prev;
                i++;
            } else {
                result += curt;
            }
        }
        return result;
    }

    /**
     * This function reads a String from back to Front and return a List
     * Return: a List of Roman letters read from the back to the front
     */
    public List<Character> readStringFromBack(String s) {
        List<Character> chars = new ArrayList<>();
        for(int i = s.length()-1; i > -1; i--) {
            chars.add(s.charAt(i));
        }
        return chars;
    }

    /**
     * This method checks if a number is power of three
     *
     * @param n number that is in digits
     * @return  true if it is power of three
     *          use the log math operation to determine the result
     */
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /**
     * Method finds the common longest prefix among an array of Strings
     *
     * @param strs  array of strings
     * @return      the longest common prefix
     *              empty string if longest common prefix does not exist
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for(int i=0; ;i++) {
            if(i >= strs[0].length())
                return result.toString();
            Character thisChar = strs[0].charAt(i);
            for(String str: strs) {
                if(i >= str.length() || thisChar != str.charAt(i))
                    return result.toString();
            }
            result.append(thisChar);
        }
    }

    /**
     * This method plays a simple FizzBuzz game:
     * Create a list of numbers but replace every multiple
     * of 3 to Fizz, 5 to Buzz, and 15 to FizzBuZZ
     *
     * @param n Length of the list
     * @return  A list of Strings containing FizzBuzzes
     */
    public List<String> fizzBuzz(int n) {
        String str1 = "Fizz";
        String str2 = "Buzz";
        List<String> result = new ArrayList<>();
        for(int i=1; i<n+1; i++) {
            if(i%3 == 0 && i%5 == 0)
                result.add(str1+str2);
            else if(i%3 == 0)
                result.add(str1);
            else if(i%5 == 0)
                result.add(str2);
            else
                result.add(Integer.toString(i));
        }
        return result;
    }

    /**
     * This function counts number of prime numbers up till number n
     *
     * @param n The highest number it counts, inclusive
     * @return  The number of prime numbers in the list
     */
    public int countPrimes(int n) {
        int ctr = 0;
        boolean[] isMultiPrime = new boolean[n];
        for(int i=2; i<n; i++) { // starting from 2 to n
            if(isMultiPrime[i])    // If it's not prime, to next iter
                continue;
            ctr++;
            for(int j=i; j<n; j+=i)
                isMultiPrime[j] = true; // Mark all multiples of i as non-prime
        }
        return ctr;
    }

    /**
     * Method optimally checks if a number is a prime number
     *
     * @param num   input number
     * @return      true if the number is a prime number
     */
    private boolean isPrime(int num) {
        //edge cases:
        if(num < 2)
            return false;
        if(num < 4)
            return true;
        if(num % 2 ==0 || num % 3 ==0)
            return false;
        for(int i=5; i*i <= num; i+=6) {
            if(num % i == 0 || num % (i+2) == 0)
                return false;
        }
        return true;
    }

    /**
     * This method satisfies the countAndSay problem on Leetcode
     * Original problem description is relatively long so emitted here
     *
     * @param n    number of iterations
     * @return     output result after counting and saying process
     */
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String lastRst = countAndSay(n - 1);
        StringBuilder newRst = new StringBuilder();
        for(int i=0; i<lastRst.length(); i++) {
            int thisInt = Character.getNumericValue(lastRst.charAt(i));
            int counter = 0;
            while(i<lastRst.length() &&
                    Character.getNumericValue(lastRst.charAt(i)) == thisInt) {
                counter++;
                i++;
            }
            newRst.append(counter);
            newRst.append(thisInt);
            i--;
        }
        return newRst.toString();
    }

    /**
     * Given array of numbers, and target value
     * This function returns an array consist of
     * two elements representing the index number of the
     * two numbers that sums up to the target
     *
     * @param nums      array of candidate number
     * @param target    target value
     * @return          array of indexes
     */
    public int[] twoSum(int[] nums, int target) {
        //brutal force method
        /**
         int j;
         int[] result = new int[2];
         for(int i = 0; i<nums.length - 1; i++) {
         j = i+1;
         while(j < nums.length) {
         if(nums[i] + nums[j] == target) {
         result[0] = i;
         result[1] = j;

         return result;
         }
         j++;
         }
         }
         return result;
         */

        // One-pass hashTable method
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int y = target - nums[i];
            if(numsMap.containsKey(y) && numsMap.get(y) != i) {
                return new int[]{i, numsMap.get(y)};
            }
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No number pair were found!");
    }

    /**
     * Function checks if the Sudoku is valid
     *
     * @param board 2d Array representing a sudoku
     * @return      true if the sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        Set sudokuSet = new HashSet();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char sudoNum = board[i][j];
                if(Character.isDigit(sudoNum)) {
                    if(!sudokuSet.add("row" + i + sudoNum) ||
                            !sudokuSet.add("col" + j + sudoNum) ||
                            !sudokuSet.add("Block" + i/3 + j/3 + sudoNum)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * This method reverse a String in-place
     *
     * @param s input char array
     */
    public void reverseString(char[] s) {
        int j=s.length-1;
        char temp;
        for(int i=0; i<(s.length)/2; i++) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }

    /**
     * Given an integer array nums,
     * move all 0's to the end of it,
     * while maintaining the relative order of the non-zero elements.
     *
     * @param nums input array nums
     */
    public void moveZeroes(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int n: nums) {
            Integer i = n;
            numsList.add(i);
        }
        List<Integer> zerosList = new ArrayList<>();
        for(Integer n: numsList) {
            if(n == 0) {
                zerosList.add(n);
            }
        }
        numsList.removeAll(zerosList);
        numsList.addAll(zerosList);
        for(int i=0; i<nums.length; i++) {
            nums[i] = numsList.get(i);
        }
    }
}
