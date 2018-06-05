package com.offer.chapter8;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/5.
 */
public class Number59 {

    @Test
    public void test(){
        /*int[] preOrder = {1,2,3,5,6,4,7,8,2,4,8,7,3,6,5};
        int[] inOrder = {5,3,6,2,7,4,8,1,8,4,7,2,6,3,5};*/
        int[] preOrder = {1,2,3,2,3};
        int[] inOrder = {3,2,1,2,3};
        BinaryTreeNode root = new BuildBinaryTree().buildPreIn(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        System.out.println(isSymmetric(root));
    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(BinaryTreeNode root){
        if(root == null)
            return false;
        else
            return isSymmetric(root.left,root.right);
    }

    /**
     * 递归解决
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric(BinaryTreeNode left,BinaryTreeNode right){
        if(left == null && right == null)
            return true;
        else if(left != null && right != null && left.value == right.value)
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        else
            return false;
    }
}
