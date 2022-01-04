package com.me.link;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /*
         * 诀窍是用栈来存储数字；
         */
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();

        /*
         * 可以不用s3作为辅助空间，保存头结点，每次新建节点关联头结点
         */
        Deque<Integer> s3 = new LinkedList<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int addNum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int num = addNum;
            addNum = 0;

            if (!s1.isEmpty()) {
                num += s1.pop();
            }

            if (!s2.isEmpty()) {
                num += s2.pop();
            }

            if (num >= 10) {
                addNum = num / 10;
                num = num % 10;
            }
            s3.push(num);
        }

        /*
         * 不要忘记处理进位的addNum
         */
        if (addNum != 0) {
            s3.push(addNum);
        }

        ListNode head = new ListNode(10000);
        ListNode tmp = head;
        while (!s3.isEmpty()) {
            tmp.next = new ListNode(s3.pop());
            tmp = tmp.next;
        }

        return head.next;
    }
}
