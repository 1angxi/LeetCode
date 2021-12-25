package com.me.link;

/**
 * @author qiankun
 * @version 2021/12/24
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int addMore = 0;
        while (l1 != null || l2 != null) {
            int sumVal = 0;
            if (l1 != null) {
                sumVal += l1.val;
            }
            if (l2 != null) {
                sumVal += l2.val;
            }
            if (addMore > 0) {
                sumVal += addMore;
            }
            if (sumVal >= 10) {
                addMore = 1;
                sumVal = sumVal % 10;
            } else {
                addMore = 0;
            }
            if (head == null) {
                head = new ListNode(sumVal);
                tail = head;
            } else {
                tail.next = new ListNode(sumVal);
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (addMore > 0) {
            tail.next = new ListNode(1);
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
