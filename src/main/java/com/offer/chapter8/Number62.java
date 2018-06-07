package com.offer.chapter8;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/6/7.
 */
public class Number62 {

    int index = 0;

    @Test
    public void test(){
        int[] preOrder = {1,2,4,3,5,6};
        int[] inOrder = {4,2,1,5,3,6};
        BinaryTreeNode root = new BuildBinaryTree().buildPreIn(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        serialize(root);

        int[] deserialize = {1, 2, 4, -1, -1, -1, 3, 5, -1, -1, 6, -1, -1};
        BinaryTreeNode root2 = deserialize(deserialize);
        System.out.println();

    }

    /**
     * 序列化
     * @param root
     */
    public void serialize(BinaryTreeNode root){
        if(root == null)
            return;
        List<Integer> list = new ArrayList<>();
        serialize(root,list);
        System.out.println(list);
    }

    /**
     * 二叉树的先序序列化
     * @param root
     * @param list
     */
    private void serialize(BinaryTreeNode root,List<Integer> list){

        if(root == null)
        {
            list.add(-1);
            return;
        }
        list.add(root.value);
        serialize(root.left,list);

        serialize(root.right,list);
    }

    /**
     * 将一个数组反序列化为一棵树
     * @param array
     * @return
     */
    public BinaryTreeNode deserialize(int[] array){
        BinaryTreeNode root = new BinaryTreeNode(array[index]);
        root = deserialize(array,root);
        return root;
    }

    /**
     * 先序遍历的方式将一个数组反序列化为一棵树
     * @param array
     * @param root
     * @return
     */
    private BinaryTreeNode deserialize(int[] array,BinaryTreeNode root){
        if(index < array.length && array[index] != -1){
            root = new BinaryTreeNode(array[index++]);
            root.left = deserialize(array,root.left);
            root.right = deserialize(array,root.right);
        }else{
            index++;
        }
        return root;
    }

}
