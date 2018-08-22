package com.offer.chapter2.二叉树;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class BuildBinaryTree {

    @Test
    public void test(){
        int[] preorder  = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        BinaryTreeNode root = buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        System.out.println();
    }

    public BinaryTreeNode buildPreIn(int[] preOrder,int[] inOrder,int preBegin,int preEnd,int inBegin,int inEnd){
        int num = preOrder[preBegin];
        BinaryTreeNode root = new BinaryTreeNode(preOrder[preBegin]);
        if(preBegin < preEnd && inBegin < inEnd) {

            int index = 0;
            for (int i = inBegin; i <= inEnd; ++i) {
                if (inOrder[i] == num) {
                    index = i;
                    break;
                }
            }
            int length = index - inBegin;
            int rigthlength = inEnd - index;
            if(length > 0)
                root.left = buildPreIn(preOrder, inOrder, preBegin + 1, preBegin + length, inBegin, index - 1);
            if(rigthlength>0)
                root.right = buildPreIn(preOrder, inOrder, preBegin + length + 1, preEnd, index + 1, inEnd);
        }
        return root;
    }
}
