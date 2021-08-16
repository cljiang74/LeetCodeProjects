package crackcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Chapter2 {

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        ListNode start = new ListNode(0);
        start.next = head;
        while(head != null) {
            valueMap.put(head.val, valueMap.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }

        ListNode begin = start;
        while(start.next != null) {
            if(valueMap.get(start.next.val) != 1) {
                start.next = start.next.next;
                continue;
            }
            start = start.next;
        }
        return begin.next;
    }

    public static ListNode returnNthFromLast(ListNode head, int n) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow = head;
        fast = head;
        for(int i=0; i<n; i++) {
            fast = fast.next;
            if(fast == null)
                return null;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0), curt = start;
        start.next = l1;
        ListNode p = l1, q = l2;
        int carry = 0;
        while(p != null || q != null) {
            int l1Val = p != null? p.val: 0;
            int l2Val = q != null? q.val: 0;
            int sum = l1Val + l2Val + carry;
            if(sum > 9) {
                carry = 1;
                sum %= 10;
            }
            else
                carry = 0;
            curt.next = new ListNode(sum);
            curt = curt.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        if(carry > 0)
            curt.next = new ListNode(1);
        return start.next;
    }

    public static boolean isPalindrome(ListNode head) {
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /** HashSet method
         Set<ListNode> bSet = new HashSet<>();
         while(headB != null) {
         bSet.add(headB);
         headB = headB.next;
         }
         while(headA != null) {
         if(bSet.contains(headA))
         return headA;
         headA = headA.next;
         }
         return null;
         **/
        // two pointer method
        ListNode p = headA, q = headB;
        while(p != q) {
            p = p==null ? headB : p.next;
            q = q==null ? headA : q.next;
        }
        return p;
    }

    public static boolean hasCycle(ListNode head) {
        // fast pointer and slow pointer: if they catch-up, there is a infi-cycle
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) { // rule out null pointer case
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode retCycleNode(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while(head != null) {
            if (!nodes.add(head))
                return head;
            head = head.next;
        }
        return null;
    }
}
