package com.me.sort;


import java.util.Arrays;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int[] values = new int[]{4, 2, 1, 3};
        for (int val : values) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        head = new SortList().sortList(head.next);
        int i = 0;
        while (head != null) {
            values[i++] = head.val;
            head = head.next;
        }

        System.out.println(Arrays.toString(values));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return sortList(head, tail);
    }

    public ListNode sortList(ListNode head, ListNode tail) {

        if (head == null || tail == null) {
            return null;
        }

        if (head == tail) {
            /*
             * 切断联系，避免干扰
             */
            head.next = null;
            return head;
        }

        if (head.next == tail) {
            /*
             * 切断联系，避免干扰
             */
            head.next = null;
            tail.next = null;
            return merge(head, tail);
        }

        ListNode fast = head, slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode midNext = slow.next;

        /*
         * 切断联系，避免干扰
         */
        slow.next = null;
        ListNode head1 = sortList(head, slow);
        ListNode head2 = sortList(midNext, tail);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
        }

        if (head2 != null) {
            temp.next = head2;
        }

        return head.next;
    }
}
