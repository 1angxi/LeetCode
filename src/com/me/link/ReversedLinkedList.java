package com.me.link;

import java.util.List;

/**
 * @author qiankun
 * @version 2021/12/27
 */
public class ReversedLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, q = p.next, r = q.next;

        while (r != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }

        q.next = p;
        head.next = null;
        return q;
    }

    public ListNode reverseListV2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = null, q = head;

        while (q != null) {
            ListNode next = q.next;
            q.next = p;
            p = q;
            q = next;
        }

        return p;
    }

    public ListNode reverseListV3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverseListV3(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
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
