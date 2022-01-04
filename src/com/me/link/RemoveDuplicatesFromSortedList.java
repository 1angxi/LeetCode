package com.me.link;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();

        //虚拟头节点
        ListNode newHead = new ListNode(10000);
        newHead.next = head;
        ListNode t = newHead;
        while (t != null) {
            //当发现相同val时
            if (!stack.isEmpty() && stack.peek().val == t.val) {
                //因为已经排好序了，找到下一个不相同的元素
                while (t != null && stack.peek().val == t.val) {
                    t = t.next;
                }
                stack.pop();
                ListNode samePre = stack.peek();
                //改变指向
                if (samePre != null) {
                    samePre.next = t;
                }
            }
            stack.push(t);
            if(t != null) {
                t = t.next;
            }
        }

        return newHead.next;
    }
}
