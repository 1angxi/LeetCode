package com.me.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public CQueue() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();

    }

    public void appendTail(int value) {
        deque1.push(value);
    }

    public int deleteHead() {
        while (!deque1.isEmpty()){
            deque2.push(deque1.pop());
        }

        if(deque2.isEmpty()){
            return -1;
        }

        int val = deque2.pop();

        while (!deque2.isEmpty()){
            deque1.push(deque2.pop());
        }

        return val;
    }

    /**
     * 上面的方法效率不高。只有当deque2是空的时候才需要转移
     */
    public int deleteHeadV2() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }

        if (deque2.isEmpty()) {
            return -1;
        } else {
            return deque2.pop();
        }
    }
}
