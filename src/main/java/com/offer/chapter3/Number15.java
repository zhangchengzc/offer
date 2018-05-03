package com.offer.chapter3;

import com.offer.chapter2.listnode.ListNode;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/12.
 */
public class Number15 {

    @Test
    public void test() {
        try{
            ListNode listNode = new ListNode(2);
            listNode.next = new ListNode(3);
            listNode.next.next = new ListNode(4);
            System.out.println(getKTotail(listNode,4));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int getKTotail(ListNode head,int k) throws Exception {
        if(head == null)
            throw new Exception("head is null");
        if(k <= 0)
            throw new Exception("please input k > 0 ");
        ListNode cur = head;
        ListNode pre = head;
        for(int i=0 ; i < k-1 ; ++i)
        {
            cur = cur.next;
            if(cur == null)
                throw new Exception("the length of head < k");
        }
        while(cur.next != null)
        {
            pre = pre.next;
            cur = cur.next;
        }
        return pre.value;
    }
}
