package com.offer.chapter4;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/24.
 */
public class Number27 {

    BinaryTreeNode lastNode = null;

    /**
     * @see com.offer.chapter2.二叉树.BuildBinaryTree#buildPreIn(int[], int[], int, int, int, int)
     */
    @Test
    public void test(){
        int[] preorder  = new int[]{10,6,4,8,14,12,16};
        int[] inorder = new int[]{4,6,8,10,12,14,16};
        BuildBinaryTree build = new BuildBinaryTree();
        BinaryTreeNode pHead1 = build.buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        BinaryTreeNode listHead = convert(pHead1);
        System.out.println();
    }

    /**
     *
     * @param root
     * @see com.offer.chapter2.二叉树.BinaryTreeNode
     * @return
     */
    public BinaryTreeNode convert(BinaryTreeNode root){
        if(root == null)
            return null;
        convertNode(root);
        BinaryTreeNode listHead = lastNode;
        while(listHead.left != null)
            listHead = listHead.left;
        return listHead;
    }

    /**
     * 通过中序递归的方式将BinaryTreeNode中每个结点与前一个结点连接
     * 注意这里的lastNode不能通过参数形式传入convertNode方法，因为在54行每次递归回来时lastNode重新变成null。所以这里采用实例域的方法
     * 改变lastNode的值。
     * 中序遍历的典型思路：（1）遍历左子树 （2）处理结点 （3）遍历右子树
     * @param root
     */
    private void convertNode(BinaryTreeNode root){
        if(root == null)
            return;
        if(root.left != null){
            convertNode(root.left);
        }
        root.left = lastNode;
        if(lastNode != null)
            lastNode.right = root;
        lastNode = root;
        if(root.right != null)
            convertNode(root.right);
    }
}
