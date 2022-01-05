package com.me.link;

import java.util.HashSet;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/29
 */
public class IntersectionOfTwoLinkedLists {


    /**
     * 诀窍是用hashset
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> setOne = new HashSet<>();
        ListNode a = headA;
        while (a != null) {
            setOne.add(a);
            a = a.next;
        }

        ListNode c = headB;
        while (c != null) {
            if (setOne.contains(c)) {
                return c;
            }
            c = c.next;
        }

        return null;

    }

    /**
     * 诀窍是数学证明：
     * a + c ， b + c，c是公共链表长度
     * 那p1走完a+c+b， 那p2走完b+c+a，两指针会刚好相交于目标节点
     *
     * 如果没有公共链表，p1和p2走完a+b+c+c后会同时为null
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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


    /**
     * 诀窍是数学证明：
     * a + c ， b + c，c是公共链表长度
     * 那p1走完a+c+b， 那p2走完b+c+a，两指针会刚好相交于目标节点
     *
     * 如果没有公共链表，p1和p2走完a+b+c+c后会同时为null
     */
    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
