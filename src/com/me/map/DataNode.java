package com.me.map;

public class DataNode {
    int val;
    int key;
    DataNode pre, next;

    public DataNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
