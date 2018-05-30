package com.offer.chapter6;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/21.
 */
public class Number39 {


    /**
     * @see com.offer.chapter2.二叉树.BuildBinaryTree#buildPreIn(int[], int[], int, int, int, int) 根据先序遍历和中序遍历构造二叉树
     */
    @Test
    public void test(){
        int[] preorder  = new int[]{1,2,3};
        int[] inorder = new int[]{2,1,3};
        BinaryTreeNode root = new BuildBinaryTree().buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        System.out.println(getDepth(root));
        System.out.println(isBalancedBinaryTree2(root));
    }

     /**
     *通过递归求左子树和右子树中深度较大的一个
     * @param head {@link com.offer.chapter2.二叉树.BinaryTreeNode}
     * @return
     */
    public int getDepth(BinaryTreeNode head)
    {
        if(head == null)
            return 0;
        else
            return Math.max(getDepth(head.left),getDepth(head.right)) + 1;
    }

    /**
     * 结合树的深度判断树是否是平衡二叉树
     * @param head
     * @return
     */
    public boolean isBalancedBinaryTree(BinaryTreeNode head){
        if(head == null)
            return false;
        if(Math.abs(getDepth(head.left)-getDepth(head.right)) <= 1)
        {
            if(head.left == null || head.right == null)
                return true;
            else
                return isBalancedBinaryTree(head.left) && isBalancedBinaryTree(head.right);
        }else
            return false;
    }

    /**
     * 自定义可以改变value的MyInteger，因为Integer中value定义为final，所以integer中不能改变值
     */
    class MyInteger{
        int value;
        public MyInteger(int value){
            this.value = value;
        }
    }

    /**
     *
     * @param head
     * @return
     */
    public boolean isBalancedBinaryTree2(BinaryTreeNode head){
        MyInteger depth = new MyInteger(0);
        return isBalanced(head,depth);
    }

    /**
     * 使用后序遍历来为判断每个结点是否是平衡的(这里使用一个对象来保存结点的深度)
     * @param head
     * @param depth
     * @return
     */
    private boolean isBalanced(BinaryTreeNode head,MyInteger depth){
        if(head == null)
        {
            depth.value = 0;
            return true;
        }
        MyInteger left = new MyInteger(0);
        MyInteger right = new MyInteger(0);
        if(isBalanced(head.left,left) && isBalanced(head.right,right)){
            if(Math.abs(left.value - right.value) <= 1) {
                depth.value = 1 + (left.value > right.value ? left.value : right.value);
                return true;
            }
        }
        return false;
    }
}
