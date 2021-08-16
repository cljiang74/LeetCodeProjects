package crackcoding;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static crackcoding.Chapter2.*;

class Chapter2Test {

    private ListNode head;

    void setup(){
        head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }

    @Test
    void testReturnNthFromLast() {
        setup();
        assertEquals(3, returnNthFromLast(head, 2).val);
    }

    @Test
    void testReturnMiddleNode() {
        setup();
        assertEquals(2, middleNode(head).val);
    }

    @Test
    void testAddTwoNums() {
        /***
         * l1 = [2,4,3], l2 = [5,6,4]
         * Output: [7,0,8]
         */
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNums(l1, l2);
        assertEquals(7, res.val);
        assertEquals(0, res.next.val);
        assertEquals(8, res.next.next.val);
    }

    @Test
    void testCycleDetection(){
        setup();
        ListNode cychead = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        cychead.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        assertTrue(hasCycle(cychead));
        assertFalse(hasCycle(head));
    }

    @Test
    void testCycleNode(){
        setup();
        ListNode cychead = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        cychead.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        assertEquals(2, retCycleNode(cychead).val);
        assertEquals(null, retCycleNode(head));
    }
}