package com.offer.chapter8;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Created by zhangcheng on 2018/6/7.
 */
public class Number63 {

    @Test
    public void test(){
        int[] preOrder = {5,3,2,7,6,8};
        int[] inOrder = {2,3,5,6,7,8};
        BinaryTreeNode root = new BuildBinaryTree().buildPreIn(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        System.out.println(getNumK(root,7));
    }

    /**
     * 查找中序遍历的第k个数
     * @param root
     * @param k
     * @return
     */
    public int getNumK(BinaryTreeNode root, int k){
        if(root == null)
            return -1;
        int count = 1;
        BinaryTreeNode cur = root;
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || cur!=null){
            if(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }else {
                if (count == k)
                    return stack.pop().value;
                cur = stack.pop();
                cur = cur.right;
                count++;
            }
        }
        return -1;
    }
}
