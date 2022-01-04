package com.me.link;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * 诀窍是：1.辅助头结点 2.三指针穿针引线
         */
        ListNode dummy = new ListNode(100000);
        dummy.next = head;

        ListNode pre = dummy, cur = dummy.next, next = cur.next;
        while (cur != null && cur.next != null) {
            next = cur.next;

            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
