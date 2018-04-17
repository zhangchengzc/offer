package com.offer.第三章;

import com.offer.第二章.listnode.ListNode;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/17.
 */
public class Number17 {


    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(6);
        ListNode p = merge(null,null);
        System.out.println();
    }
    /**
     * 递归方式合并两个有序的链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode merge(ListNode pHead1,ListNode pHead2){
        if(pHead1 == null)
            return pHead2;
        else if(pHead2 == null)
            return pHead1;
        ListNode pNode = null;
        if(pHead1.value <= pHead2.value){
            pNode = pHead1;
            pNode.next = merge(pHead1.next,pHead2);
        }else{
            pNode = pHead2;
            pNode.next = merge(pHead1,pHead2.next);
        }
        return pNode;
    }
}
