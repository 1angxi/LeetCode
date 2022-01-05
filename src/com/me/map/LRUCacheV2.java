package com.me.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCacheV2 {

    public class DataNode {
        int val;
        int key;
        DataNode pre, next;

        public DataNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    private Map<Integer, DataNode> dataNodeMap = new HashMap<>();

    private DataNode head, tail;

    private int cap = 0;
    private int used = 0;

    public LRUCacheV2(int capacity) {
        this.cap = capacity;
        head = new DataNode(-1, -1);
        tail = new DataNode(-1, -1);
        tail.pre = tail.next = head;
        head.pre = head.next = tail;
    }

    public int get(int key) {
        if(dataNodeMap.get(key) == null){
            return -1;
        }

        removeData(dataNodeMap.get(key));
        moveToTail(dataNodeMap.get(key));

        return dataNodeMap.get(key).val;
    }

    public void put(int key, int value) {
        DataNode dataNode = new DataNode(key, value);
        ;
        if (used == 0) {
            head.next = dataNode;
            tail.pre = dataNode;

            dataNode.next = tail;
            dataNode.pre = head;
        } else {

            if (dataNodeMap.get(key) == null) {
                dataNode.pre = tail.pre;
                dataNode.next = tail;
                tail.pre.next = dataNode;
                tail.pre = dataNode;
            } else {
                dataNodeMap.get(key).val = value;
                removeData(dataNodeMap.get(key));
                moveToTail(dataNodeMap.get(key));
            }
        }

        if (used == cap) {//删除最近未使用的数据
            DataNode remove = removeHead();
            dataNodeMap.put(remove.key, null);
        } else {
            used++;
        }

        dataNodeMap.put(key, dataNode);
    }

    public DataNode removeHead() {
        DataNode data = head.next;
        data.next.pre = head;
        head.next  = data.next;
        return data;
    }

    public void removeData(DataNode dataNode){
        dataNode.pre.next = dataNode.next;
        dataNode.next.pre = dataNode.pre;
    }

    public void moveToTail(DataNode dataNode) {
        tail.next = dataNode;
        head.pre = dataNode;
        dataNode.pre = tail;
        dataNode.next = head;
    }
}
