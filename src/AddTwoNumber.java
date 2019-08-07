/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

class Solution {

    // Definition for singly-linked list
    // static class
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode newNode = new ListNode(0);
        ListNode p = newNode;
        int val;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int xVal = (l1 != null) ? l1.val : 0;
            int yVal = (l2 != null) ? l2.val : 0;

            val = (xVal + yVal + carry) % 10;
            carry = (xVal + yVal + carry) / 10;
            p.next = new ListNode(val);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            p.next = new ListNode(carry);
        }

        return newNode.next;
    }
}
