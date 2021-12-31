package com.me.link;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        ListNode preK = head;

        if(head == null){
            return head;
        }

        /*
         * 注意旋转的时候可能会超过链表的长度，所以先要对k取模；
         */
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        k = k % size;

        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }

        /*
         * 快慢指针
         */
        while (tail.next != null) {
            tail = tail.next;
            preK = preK.next;
        }
        tail.next = head;
        head = preK.next;
        preK.next = null;
        return head;
    }

}
