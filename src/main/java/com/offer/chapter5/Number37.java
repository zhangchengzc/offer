package com.offer.chapter5;

import com.offer.chapter2.listnode.ListNode;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/18.
 */
public class Number37 {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l3.next = l4;
        l4.next = l5;
        l1.next = l2;
        l2.next = l4;
        System.out.println(getFirstSameNode(l3,l1).value);
    }

    /**
     * 首先计算两个链表的长度，然后让长的链表先遍历，直至两个链表相同长度的时候再一起遍历直至遍历到相同的结点
     * @param h1
     * @param h2
     * @return
     */
    public ListNode getFirstSameNode(ListNode h1, ListNode h2){
        if(h1 == null || h2 == null)
            return null;
        ListNode cur1 = h1;
        ListNode cur2 = h2;
        int length1 = length(cur1);
        int length2 = length(cur2);
        int distLength = (length1 > length2) ? (length1-length2) : (length2-length1);
        ListNode longList = (length1 > length2) ? cur1 : cur2;
        ListNode shortList = (length1 > length2) ? cur2 : cur1;
        while(distLength > 0){
            longList = longList.next;
            distLength--;
        }
        while(longList != shortList && longList != null)
        {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    /**
     * 计算链表的长度
     * @param cur
     * @return
     */
    private int length(ListNode cur) {
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
