package com.offer.heap;

/**
 * Created by zhangcheng on 2018/3/13.
 */
public class BinaryHeapDemo {
    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap(50);
        bh.insert(2);
        bh.insert(7);
        bh.insert(26);
        bh.insert(25);
        bh.insert(19);
        bh.insert(17);
        bh.insert(1);
        bh.insert(90);
        bh.insert(3);
        bh.insert(36);
        bh.display();
        bh.remove();
        bh.display();
    }
}
