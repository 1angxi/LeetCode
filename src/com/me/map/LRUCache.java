package com.me.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankun
 * @version 2021/12/28
 */
public class LRUCache {


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
