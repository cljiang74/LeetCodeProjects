import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeProjectsTest {
    private LeetCodeProjects test;

    @BeforeEach
    void setUp() {
        test = new LeetCodeProjects();
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
    }

    @Test
    void testIsPalindrome() {
    }

    @Test
    void hasCycle() {
    }

    @Test
    void rotate() {
    }

    @Test
    void romanToInt() {
    }

    @Test
    void readStringFromBack() {
    }

    @Test
    void isPowerOfThree() {
    }

    @Test
    void longestCommonPrefix() {
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