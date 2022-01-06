package com.me.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode listNode = new ListNode(10000);
        ListNode org = listNode;
        listNode.next = head;
        while (listNode != null) {
            nodes.add(listNode);
            listNode = listNode.next;
        }

        if ((nodes.size() - n - 1) >= 0) {
            ListNode pre = nodes.get(nodes.size() - n - 1);
            pre.next = pre.next.next;
            return org.next;
        } else {
            return null;
        }
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        //使用哑结点处理删除头结点的情况
        ListNode dummy = new ListNode(1000000);
        dummy.next = head;
        ListNode second = dummy, first = head;

        //需要前进n步
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }

        //开始正常走
        while (first != null) {
            second = second.next;
            first = first.next;
        }

        //删除节点
        second.next = second.next.next;
        return dummy.next;
    }
}
