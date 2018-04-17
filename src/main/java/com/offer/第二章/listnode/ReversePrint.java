package com.offer.第二章.listnode;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class ReversePrint {

    @Test
    public void test(){
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        reversePrint2(listNode);
    }
    public void reversePrint(ListNode head)
    {
        if(head == null)
            return;
        if(head.next  != null)
            reversePrint(head.next);
        System.out.println(head.value);
    }

    public void reversePrint2(ListNode head)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while(head!=null)
        {
            stack.addFirst(head.value);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.poll());
        }
    }
}
