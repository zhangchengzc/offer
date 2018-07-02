package com.offer.heap;

/**
 * Created by zhangcheng on 2018/3/13.
 */
public class HeapNode {
    private int value;

    HeapNode (int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
