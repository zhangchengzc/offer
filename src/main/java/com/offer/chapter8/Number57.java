package com.offer.chapter8;

import com.offer.chapter2.listnode.ListNode;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/5.
 */
public class Number57 {

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        ListNode newHead = deleteRepeatedNode(head);
        System.out.println();
    }

    /**
     * 对于链表头结点也需要改变的情况，通常可以创建一个结点指向头结点的方法来处理，最后返回这个新结点的下一个结点。
     * @param head
     * @return
     */
    public ListNode deleteRepeatedNode(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        boolean flag = true;
        while(cur != null){
            if(cur.next!=null && cur.value == cur.next.value) {
                cur = cur.next;
                flag = false;
            }else {
                if(flag){
                    cur = cur.next;
                    pre = pre.next;
                }else{
                    cur = cur.next;
                    pre.next = cur;
                    flag = true;
                }
            }
        }
        return newHead.next;
    }
}
