package com.me.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/29
 */
public class MinStack {

    Deque<Integer> norm;
    Deque<Integer> min;

    public MinStack() {
        norm = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        norm.push(val);
        if (min.size() > 0) {
            min.push(val < min.peek() ? val : min.peek());
        } else {
            min.push(val);
        }
    }

    public void pop() {
        norm.pop();
        min.pop();
    }

    public int top() {
        return norm.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
