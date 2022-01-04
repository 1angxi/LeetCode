package com.me.link;

import java.util.List;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
}
