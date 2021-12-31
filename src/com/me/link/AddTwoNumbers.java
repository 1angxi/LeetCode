package com.me.link;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
}
