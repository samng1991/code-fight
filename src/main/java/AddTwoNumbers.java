import common.ListNode;

import java.util.Arrays;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;

        // resultHead is the last ListNode, result is first dummy result
        ListNode resultHead = new ListNode(0), result = resultHead;
        int total = 0;
        while (listNode1 != null || listNode2 != null) {

            int int1 = listNode1 == null ? 0 : listNode1.val;
            int int2 = listNode2 == null ? 0 : listNode2.val;
            total = total + int1 + int2;

            ListNode tempListNode = new ListNode(total % 10);
            resultHead.next = tempListNode;
            resultHead = tempListNode;

            total = total / 10;

            if (listNode1 != null) listNode1 = listNode1 = listNode1.next;
            if (listNode2 != null) listNode2 = listNode2.next;
        }
        if (total > 0) {
            resultHead.next = new ListNode(total);
        }

        return result.next;
    }

    public static void main(String args[]) throws Exception {
        ListNode listNode1 = ListNode.arrayToListNode(new int[]{1, 2, 3, 4});
        ListNode listNode2 = ListNode.arrayToListNode(new int[]{9, 9, 9, 9, 9});
        System.out.println(listNode1.toReverseString());
        System.out.println(listNode2.toReverseString());
        System.out.println(addTwoNumbers(listNode1, listNode2).toReverseString());
    }

}
