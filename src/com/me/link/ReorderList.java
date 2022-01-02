package com.me.link;

import java.util.List;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        //找到中点
        //翻转后面的链表
        //链表合并
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode midPre = head, mid = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            midPre = midPre.next;
            mid = mid.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            midPre = midPre.next;
            mid = mid.next;
        }

        //断开连接
        midPre.next = null;

        //翻转
        mid = reverse(mid);

        //合并
        merge(head, mid);

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, q = head.next;
        p.next = null;
        while (q != null) {
            ListNode tm = q.next;
            q.next = p;
            p = q;
            q = tm;
        }

        return p;
    }

    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (p1 != null && p2 != null) {
            temp.next = p1;
            p1 = p1.next;
            temp = temp.next;
            temp.next = p2;
            p2 = p2.next;
            temp = temp.next;
        }

        if (p1 != null) {
            temp.next = p1;
        }

        if (p2 != null) {
            temp.next = p2;
        }

        return head.next;
    }
}
