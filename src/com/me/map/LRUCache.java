package com.me.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class LRUCache {


    /**
     * 诀窍是使用一个数组+双向联调缓存数据。
     * 其实本质上就是LinkedHashMap的实现原理
     */
    class DataNode {
        int val;
        int key;
        DataNode pre, next;

        public DataNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;

    Map<Integer, DataNode> map = new HashMap<>();

    DataNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DataNode(-1, -1);
        tail = new DataNode(-1, -1);
        tail.pre = tail.next = head;
        head.pre = head.next = tail;
    }

    public int get(int key) {
        DataNode dataNode = map.get(key);
        if (dataNode == null) {
            return -1;
        }

        moveToHead(dataNode);

        return dataNode.val;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            map.get(key).val = value;

            DataNode dataNode = map.get(key);
            moveToHead(dataNode);

        } else {
            if (capacity == 0) { //清理tail的数据
                map.put(tail.pre.key, null);
                removeFromTail();
            }
            DataNode dataNode = new DataNode(key, value);
            addToHead(dataNode);

            if (capacity > 0) {
                capacity--;
            }

            map.put(key, dataNode);
        }
    }

    public void removeNode(DataNode dataNode) {
        dataNode.pre.next = dataNode.next;
        dataNode.next.pre = dataNode.pre;
    }

    public void addToHead(DataNode dataNode) {
        dataNode.next = head.next;
        dataNode.pre = head;
        head.next.pre = dataNode;
        head.next = dataNode;
    }

    public void removeFromTail() {
        DataNode temp = tail.pre.pre;
        temp.next = tail;
        tail.pre = temp;
    }

    private void moveToHead(DataNode node) {
        removeNode(node);
        addToHead(node);
    }
}
