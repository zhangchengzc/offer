package com.offer.chapter4;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/23.
 */
public class Number26 {


    @Test
    public void test(){
        ComplexListNode pHead = new ComplexListNode(1);
        pHead.next = new ComplexListNode(2);
        pHead.next.next = new ComplexListNode(3);
        pHead.next.next.other = pHead;
        ComplexListNode pHead2 = cloneNodes(pHead);
        System.out.println();
    }

    /**
     * 复杂链表的复制
     * @param pHead
     * @return
     */
    public ComplexListNode cloneNodes(ComplexListNode pHead){
        if(pHead == null)
            return null;
        pHead = mergeCloneNext(pHead);
        pHead = cloneOther(pHead);
        ComplexListNode pHead2 = separateNodes(pHead);
        return pHead2;
    }

    /**
     * 拆开两个链表
     * @param pHead
     * @return
     */
    private ComplexListNode separateNodes(ComplexListNode pHead){
        ComplexListNode pHead2 = pHead.next;
        ComplexListNode curNode = pHead2;
        ComplexListNode curNode2 = pHead;
        while(curNode.next != null)
        {
            curNode2.next = curNode2.next.next;
            curNode2 = curNode2.next;
            curNode.next = curNode.next.next;
            curNode = curNode.next;
        }
        curNode2.next = null;
        return pHead2;
    }

    /**
     * 将新复制的只含next链表和原始链表合并
     * @param pHead
     * @return
     */
    private ComplexListNode mergeCloneNext(ComplexListNode pHead){
        ComplexListNode curNode = pHead;
        while(curNode != null){
            ComplexListNode p = new ComplexListNode(curNode.value);
            p.next = curNode.next;
            curNode.next = p;
            curNode = p.next;
        }
        return pHead;
    }

    /**
     *复制链表的other指针
     * @param pHead
     * @return
     */
    private ComplexListNode cloneOther(ComplexListNode pHead){
        ComplexListNode curNode = pHead;
        ComplexListNode nextNode = pHead.next;
        while(curNode != null)
        {
            if(curNode.other != null) {
                nextNode.other = curNode.other.next;
            }
            curNode = curNode.next.next;
            if(curNode != null) {
                nextNode = nextNode.next.next;
            }
        }
        return pHead;
    }
}

class ComplexListNode{

    int value;
    ComplexListNode next;
    ComplexListNode other;

    public ComplexListNode(int value){
        this.value = value;
    }
}
