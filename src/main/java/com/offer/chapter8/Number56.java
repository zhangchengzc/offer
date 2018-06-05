package com.offer.chapter8;

import com.offer.chapter2.listnode.ListNode;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/4.
 */
public class Number56 {

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next.next;
        System.out.println(getEntryNode(head).value);
    }

    /**
     * 链表中环的问题一般都涉及到两个指针相遇问题
     * @param head {@link com.offer.chapter2.listnode.ListNode}
     * @return
     */
    public ListNode getEntryNode(ListNode head){
        //第一步：求出环中的结点数
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = fast.next;
        int countCircle = 1;
        while(p != fast){
            p = p.next;
            countCircle++;
        }
        //第二步：让一个结点先走countCircle步，然后两个结点一起前进，相遇的结点就是入口结点
        fast = head;
        slow = head;
        for (int i = 1; i <= countCircle ; i++) {
            fast = fast.next;
        }
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
