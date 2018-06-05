package com.offer.chapter8;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/5.
 */
public class Number58 {

    @Test
    public void test(){
        int[] preOrder = {1,2,3,4,};//5,6,8,9,7};
        int[] inOrder = {3,2,4,1};//,8,6,9,5,7};
        BinaryTreeNode head = new BuildBinaryTree().buildPreIn(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        BinaryTreeNode p2 = head.left;
        BinaryTreeNode p3 = p2.left;
        BinaryTreeNode p4 = p2.right;
        /*BinaryTreeNode p5 = head.right;
        BinaryTreeNode p6 = p5.left;
        BinaryTreeNode p7 = p5.right;
        BinaryTreeNode p8 = p6.left;
        BinaryTreeNode p9 = p6.right;*/
        p3.parent = p2;p4.parent = p2;p2.parent = head;//p8.parent = p6;p9.parent = p6;p6.parent = p5; p7.parent = p5;p5.parent = head;
        BinaryTreeNode next = getNextNode(head,head);
        if(next == null)
            System.out.println("");
        else
            System.out.println(next.value);

    }

    /**
     * 本题需要将该结点是父节点的左孩子还是右孩子分开考虑
     * @param root
     * @param node
     * @return
     */
    public BinaryTreeNode getNextNode(BinaryTreeNode root,BinaryTreeNode node){
        if(node.right != null)
            return getMostLeftNode(node.right);
        else if(node == root)
            return null;
        else if(node == node.parent.left)
            return node.parent;
        else{
            BinaryTreeNode p = node;
            while(p.parent != null && p.parent.right == p)
                p = p.parent;
            if(p == root)
                return null;
            else
                return p.parent;
        }
    }

    /**
     * 找到该结点最左边的结点
     * @param node
     * @return
     */
    private BinaryTreeNode getMostLeftNode(BinaryTreeNode node){
        BinaryTreeNode p = node;
        while(p.left != null)
            p = p.left;
        return p;
    }
}
