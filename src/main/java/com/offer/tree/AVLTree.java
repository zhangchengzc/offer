package com.offer.tree;

/**
 * Created by zhangcheng on 2018/3/12.
 */
public class AVLTree<T extends Comparable> extends BinarySearchTree<T> {

    private AVLNode<T> root;

    /**
     * 递归实现
     * @param subtree
     * @return
     */
    private int height(AVLNode<T> subtree){
        if (subtree==null){
            return 0;
        }else {
            int l=height(subtree.left);
            int r=height(subtree.right);
            return (l>r) ? (l+1):(r+1);//返回并加上当前层
        }
    }

    /**
     * 左左单旋转(LL旋转) w变为x的根结点, x变为w的右子树
     * @param x
     * @return
     */
    private AVLNode<T> singleRotateLeft(AVLNode<T> x){
        //把w结点旋转为根结点
        AVLNode<T> w=  x.left;
        //同时w的右子树变为x的左子树
        x.left=w.right;
        //x变为w的右子树
        w.right=x;
        //重新计算x/w的高度
        x.height=Math.max(height(x.left),height(x.right))+1;
        w.height=Math.max(height(w.left),x.height)+1;
        return w;//返回新的根结点
    }

    /**
     * 右右单旋转(RR旋转) x变为w的根结点, w变为x的左子树
     * @return
     */
    private AVLNode<T> singleRotateRight(AVLNode<T> w){

        AVLNode<T> x=w.right;

        w.right=x.left;
        x.left=w;

        //重新计算x/w的高度
        w.height=Math.max(height(w.left),height(w.right))+1;
        x.height=Math.max(height(x.left),w.height)+1;

        //返回新的根结点
        return x;
    }

    /**
     * 左右旋转(LR旋转) x(根) w y 结点 把y变成根结点
     * @return
     */
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> x){
        //w先进行RR旋转
        x.left=singleRotateRight(x.left);
        //再进行x的LL旋转
        return singleRotateLeft(x);
    }

    /**
     * 右左旋转(RL旋转)
     * @param x
     * @return
     */
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> x){
        //先进行LL旋转
        x.right=singleRotateLeft(x.right);
        //再进行RR旋转
        return singleRotateRight(x);
    }

    /**
     * 插入方法
     * @param data
     */
    @Override
    public void insert(T data) {
        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root=insert(data,root);
    }

    private AVLNode<T> insert(T data , AVLNode<T> p){

        //说明已没有孩子结点,可以创建新结点插入了.
        if(p==null){
            p=new AVLNode<T>(data);
        }else if(data.compareTo(p.data)<0){//向左子树寻找插入位置
            p.left=insert(data,p.left);

            //插入后计算子树的高度,等于2则需要重新恢复平衡,由于是左边插入,左子树的高度肯定大于等于右子树的高度
            if(height(p.left)-height(p.right)==2){
                //判断data是插入点的左孩子还是右孩子
                if(data.compareTo(p.left.data)<0){
                    //进行LL旋转
                    p=singleRotateLeft(p);
                }else {
                    //进行左右旋转
                    p=doubleRotateWithLeft(p);
                }
            }
        }else if (data.compareTo(p.data)>0){//向右子树寻找插入位置
            p.right=insert(data,p.right);

            if(height(p.right)-height(p.left)==2){
                if (data.compareTo(p.right.data)<0){
                    //进行右左旋转
                    p=doubleRotateWithRight(p);
                }else {
                    p=singleRotateRight(p);
                }
            }
        }
        else
            ;//if exist do nothing
        //重新计算各个结点的高度
        p.height = Math.max( height( p.left ), height( p.right ) ) + 1;

        return p;//返回根结点
    }
}
