package com.offer.第三章;

import com.offer.第二章.listnode.ListNode;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/12.
 */
public class Number16 {

    @Test
    public void test(){
        try {
            ListNode listNode = new ListNode(2);
            listNode.next = new ListNode(3);
            listNode.next.next = new ListNode(4);
            ListNode p = reverseNode3(listNode);
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 使用头插法倒置一个链表
     * @param head
     * @return
     * @throws Exception
     */
    public ListNode reverseNode(ListNode head) throws Exception {
        if(head == null)
            throw new Exception("head is null");
        ListNode p = new ListNode(0);
        p.next = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null)
        {
            cur.next = p.next;
            p.next = cur;
            cur = next;
            next = next.next;
        }
        cur.next = p.next;
        p.next = cur;
        return p.next;
    }

    /**
     * 通过指针翻转逆置一个链表
     * @param head
     * @return
     * @throws Exception
     */
    public ListNode reverseNode2(ListNode head) throws Exception{
        if(head == null)
            throw new Exception("head is null");
        ListNode pre = null;
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null)
        {
            ListNode next = cur.next;
            if(next == null)
                newHead = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return newHead;

    }

    /**
     * 递归的方式逆置一个链表
     * @param head
     * @return
     */
    public ListNode reverseNode3(ListNode head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode reverseNode = reverseNode3(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }
}
