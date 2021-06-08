import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeProjectsTest {
    private LeetCodeProjects test;

    @BeforeEach
    void setUp() {
        test = new LeetCodeProjects();
    }

    /**
     * Helper function to quickly create linked list containing
     * n nodes in a ascending order, spacing 1
     *
     * @param n number of nodes in the list
     * @return  Head node of the created Linked list
     *          null if n < 0
     */
    ListNode createList(int n) {
        if(n < 0)
            return null;
        ListNode head = new ListNode(0);
        ListNode curtNode = head;
        for(int i=1; i<n; i++) {
            curtNode.next = new ListNode(i);
            curtNode = curtNode.next;
        }
        return head;
    }

    /**
     * Helper function to truncate a list
     * new list starting at position n
     *
     * ie: n = 2 for 0->1->2->3 creates 2->3 and return 2
     *
     * @param head  header of the original list
     * @param n     new starting position
     * @return      header of the new list
     *              null if n < 0
     *              does not check upper bounds
     */
    ListNode truncateList(ListNode head, int n) {
        int i = 0;
        while(i < n) {
            head = head.next;
            i++;
        }
        return head;
    }

    /**
     * This method checks if two Linked List equals each other
     *
     * @param head1 head of the list one
     * @param head2 head of the list two
     * @return      true if two lists are identical(all nodes are the same)
     *              false if not or exception thrown
     */
    boolean listEqual(ListNode head1, ListNode head2) {
        List<Integer> head1List = new ArrayList<>();
        List<Integer> head2List = new ArrayList<>();
        while(head1 != null) {
            head1List.add(head1.val);
            head1 = head1.next;
        }
        while(head2 != null) {
            head2List.add(head2.val);
            head2 = head2.next;
        }
        return (head1List.size() == head2List.size() && head1List.equals(head2List));
    }

    @Test
    void reverse() {
        int x = 15213;
        assertEquals(31251, test.reverse(x));
    }

    @Test
    void firstUniqChar() {
        String randomAt5 = "RandomRando";
        assertEquals(5, test.firstUniqChar(randomAt5));
    }

    @Test
    void isPalindrome() {
        String palinString = "coloroloc";
        String notPalinString = "colololo";
        assertTrue(test.isPalindrome(palinString));
        assertFalse(test.isPalindrome(notPalinString));
    }

    @Test
    void myAtoi() {
        String intString = "1023120392";
        int expectAns = 1023120392;
        assertEquals(expectAns, test.myAtoi(intString));
    }

    @Test
    void strStr() {
        String haystack = "bunchOfNeedles";
        String needle = "Needle";
        String unExist = "NotNeedle";

        assertEquals(7, test.strStr(haystack, needle));
        assertEquals(-1, test.strStr(haystack, unExist));
    }

    @Test
    void deleteNode() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        test.deleteNode(node2);
        List<Integer> resultList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        expectList.add(0);
        expectList.add(1);
        expectList.add(3);
        expectList.add(4);
        ListNode start = new ListNode(0, head);
        ListNode curtNode = start.next;
        while(curtNode != null) {
            resultList.add(curtNode.val);
            curtNode = curtNode.next;
        }

        assertEquals(expectList, resultList);
    }

    @Test
    void removeNthFromEnd() throws Exception {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        test.removeNthFromEnd(head, 3);
        try {
            test.removeNthFromEnd(head, 0);
        } catch (Exception e) { // assertTrue
            assertEquals(0, 0);
        }
        List<Integer> resultList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        expectList.add(0);
        expectList.add(1);
        expectList.add(3);
        expectList.add(4);
        ListNode start = new ListNode(0, head);
        ListNode curtNode = start.next;
        while(curtNode != null) {
            resultList.add(curtNode.val);
            curtNode = curtNode.next;
        }

        assertEquals(expectList, resultList);
    }

    @Test
    void reverseList() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = test.reverseList(head);

        List<Integer> actualRst = new ArrayList<>();
        List<Integer> expectedRst = new ArrayList<>();
        while(head != null) {
            actualRst.add(head.val);
            head = head.next;
        }
        expectedRst.add(4);
        expectedRst.add(3);
        expectedRst.add(2);
        expectedRst.add(1);
        expectedRst.add(0);

        assertEquals(expectedRst, actualRst);
    }

    @Test
    void mergeTwoLists() {
        ListNode head = createList(5);
        ListNode head2 = createList(6);
        ListNode head3 = truncateList(head2, 5);
        head = test.mergeTwoLists(head, head3);

        assertTrue(listEqual(head2, head));
    }

    @Test
    void testIsPalindrome() {
        ListNode head = createList(3);
        ListNode curtNode = head;
        assertFalse(test.isPalindrome(head));
        while(curtNode.next != null)
            curtNode = curtNode.next;
        curtNode.next = new ListNode(1);
        curtNode.next.next = new ListNode(0);
        curtNode = head;

        assertTrue(test.isPalindrome(head));
    }

    @Test
    void hasCycle() {
        ListNode head = createList(100);
        assertFalse(test.hasCycle(head));
        ListNode tail = head;
        ListNode midNode = new ListNode(0);
        int ctr = 0;

        while(tail.next != null) {
            if(ctr == 50) {
                midNode = tail;
            }
            tail = tail.next;
            ctr++;
        }
        tail.next = midNode;

        assertTrue(test.hasCycle(head));
    }

    @Test
    void rotate() {
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
        int[][] origArr = {{5,  1,  9, 11},
                           {2,  4,  8, 10},
                           {13, 3,  6, 7},
                           {15, 14, 12, 16}};
        int[][] expectRst = {{15, 13, 2, 5},
                             {14, 3,  4, 1},
                             {12, 6,  8, 9},
                             {16, 7, 10, 11}};
        test.rotate(origArr);

        assertTrue(Arrays.deepEquals(expectRst, origArr));
    }

    @Test
    void romanToInt() {
        String romanLetters = "LVIII";
        assertEquals(58, test.romanToInt(romanLetters));
    }

    @Test
    void isPowerOfThree() {
        int isPowThree = 531441;
        int isNotPowThree = 545664;

        assertTrue(test.isPowerOfThree(isPowThree));
        assertFalse(test.isPowerOfThree(isNotPowThree));
    }

    @Test
    void longestCommonPrefix() {
        String strs[] = {"Harry Potter and His Best Friends", "Harry Potter and the Order of Phoenix"};
        String strs2[] = {"Harry Potter and His Best Friends",
                "Harry Potter and the Order of Phoenix", " &&Harry Potter and His Power of Jedi"};
        String expectRst = "Harry Potter and ";

        assertEquals(expectRst, test.longestCommonPrefix(strs));
        assertEquals("", test.longestCommonPrefix(strs2));
    }

    @Test
    void fizzBuzz() {
    }

    @Test
    void countPrimes() {
    }

    @Test
    void countAndSay() {
    }

    @Test
    void maxDepth() {
    }
}