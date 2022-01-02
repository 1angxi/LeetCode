package com.me.link;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode dump = new ListNode(-50000);
        dump.next = head;

        ListNode leftPre = dump, leftNode = dump.next;
        ListNode rightNode = dump, rightNext = dump.next;

        int i = 1;
        while (i < right) {
            rightNode = rightNode.next;
            rightNext = rightNext.next;

            if (i < left) {
                leftPre = leftPre.next;
                leftNode = leftNode.next;
            }
            i++;
        }

        if (leftNode == null || rightNode == null) {
            return head;
        }

        leftPre.next = null;
        rightNode.next = null;

        ListNode newOne = reverse(leftNode);

        leftPre.next = newOne;
        leftNode.next = rightNext;

        return dump.next;
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
}
