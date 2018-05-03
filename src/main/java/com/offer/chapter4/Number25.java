package com.offer.chapter4;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.*;

/**
 * Created by zhangcheng on 2018/4/20.
 */
public class Number25 {

    /**
     * @see com.offer.chapter2.二叉树.BuildBinaryTree#buildPreIn(int[], int[], int, int, int, int)
     */
    @Test
    public void test(){
        int[] preorder  = new int[]{10,5,4,7,12};
        int[] inorder = new int[]{4,5,7,10,12};
        BuildBinaryTree build = new BuildBinaryTree();
        BinaryTreeNode pHead1 = build.buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        getPath(pHead1,22);
    }

    /**
     *
     * @param root
     * @param num
     */
    public void getPath(BinaryTreeNode root,int num){
        if(root == null)
            return;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int curSum = 0;
        getPath(root,num,stack,curSum);
    }

    /**
     * 根据树的前序递归遍历打印路径
     * @param root
     * @param num
     * @param stack
     * @param curSum
     */
    private void getPath(BinaryTreeNode root, int num, ArrayDeque<Integer> stack, int curSum){
        curSum += root.value;
        stack.push(root.value);
        boolean flag = root.left == null && root.right == null;
        if(flag && num == curSum){
            List<Integer> list = new ArrayList<>(stack);
            Collections.reverse(list);
            System.out.println(list);
        }
        if(root.left != null)
            getPath(root.left,num,stack,curSum);
        if(root.right != null)
            getPath(root.right,num,stack,curSum);
        stack.pop();
    }
}
