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
public class MinStack2 {

    Deque<Integer> norm;
    int min = 0;

    public MinStack2() {
        norm = new LinkedList<>();
    }

    public void push(int val) {
        //初始不减。直接放入
        if (norm.size() == 0) {
            norm.push(0);
            min = val;
        } else {
            //这里会有溢出
            int gap = val - min;
            norm.push(gap);
            if (gap < 0) {
                min = val;
            }
        }
    }

    public void pop() {
        Integer val = norm.pop();
        min = val < 0 ? min - val : min;
    }

    public int top() {
        return min + norm.peek();
    }

    public int getMin() {
        return min;
    }
}
