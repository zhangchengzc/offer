package com.offer.chapter7;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Created by zhangcheng on 2018/5/31.
 */
public class Number50 {


    /**
     * @see com.offer.chapter2.二叉树.BuildBinaryTree#buildPreIn(int[], int[], int, int, int, int)
     */
    @Test
    public void test(){
        double a = 0.23111112222;
        System.out.println((float) a);
        long b = 2147483649l;
        System.out.println((int)b);
        System.out.println(Double.compare(0.1d,0.1f));
        int[] pre = {1,2,4,5,3,6,10,7,8};
        int[] in = {4,2,5,1,6,10,3,8,7};
        BinaryTreeNode head = new BuildBinaryTree().buildPreIn(pre,in,0,pre.length-1,0,in.length-1);
        BinaryTreeNode node1 = head.right.left;
        BinaryTreeNode node2 = head.right.right.left;
        System.out.println(getSameAncestor(node1,node2,head));
    }

    /**
     * 使用两个栈保存分别保存树根节点到两个结点的路径，然后根据这两个路径来判断第一个祖先结点。
     * @param node1
     * @param node2
     * @param head
     * @return
     */
    public int getSameAncestor(BinaryTreeNode node1,BinaryTreeNode node2,BinaryTreeNode head){
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        getPathNode(node1,head,stack1);
        int length1 = stack1.size();
        getPathNode(node2,head,stack2);
        int length2 = stack2.size();
        int length = length1 > length2 ? length2:length1;
        int temp = -1;
        for (int i = 0; i < length; i++) {
            if((temp = stack1.removeLast()) == stack2.removeLast() && stack1.getLast() != stack2.getLast())
                return temp;
        }
        return temp;
    }
    /**
     * 递归先序遍历
     * @param node
     * @param head
     * @param stack
     */
    private void getPathNode(BinaryTreeNode node,BinaryTreeNode head,ArrayDeque<Integer> stack){
        stack.push(head.value);
        if(head.value == node.value)
            return;
        else{
            if(head.left != null)
                getPathNode(node,head.left,stack);
            if(stack.peek() == node.value)
                return;
            if(head.right != null)
                getPathNode(node,head.right,stack);
            if(stack.peek() == node.value)
                return;
            stack.pop();
        }
    }
}
