package com.offer.chapter2.listnode;


import java.util.List;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value)
    {
        this.value = value;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode p = listNode.next = new ListNode(3);

        System.out.println();
    }
}
