package com.offer.heap;

/**
 * Created by zhangcheng on 2018/3/13.
 */
public class HeapSort {
    private HeapNode[] heapArray = null;
    private int maxSize;
    private int currentSize;

    HeapSort(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new HeapNode[this.maxSize];
        currentSize = 0;
    }

    private HeapNode remove() {
        HeapNode root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        if (index >= currentSize || index < 0)
            return ;

        HeapNode tmpNode = heapArray[index];
        while (index < currentSize/2) {
            int leftChildIndex = 2*index + 1;
            int rightChildIndex = leftChildIndex + 1;

            //在左右子数中找到最大的那个
            int largeChildIndex = 0;
            if (rightChildIndex < currentSize && heapArray[leftChildIndex].getValue() < heapArray[rightChildIndex].getValue()) {
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }

            //只有目标节点比孩子节点小才满足交换，否则直接跳出
            if (tmpNode.getValue() > heapArray[largeChildIndex].getValue())
                break;

            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = tmpNode;
    }

    //将一个无序数组建堆就是从最后一个有子节点的节点开始，依次向下筛选
    public void buildHeap() {
        for (int i = currentSize/2 - 1; i >= 0; --i) {
            trickleDown(i);
        }
    }

    private void insertAt(int index, HeapNode node) {
        if (index < 0 || index >= maxSize)
            return ;

        heapArray[index] = node;
    }

    //生成一个无序的数组
    public void buildRandomArray() {
        for (int i = 0; i < maxSize; ++i) {
            int randomValue = (int)(Math.random()*100);
            HeapNode node = new HeapNode(randomValue);
            insertAt(currentSize++, node);
        }
    }

    public void heapSort() {
        for (int i = currentSize-1; i > 0; --i) {
            HeapNode node = remove();
            insertAt(i, node);
//          System.out.println("insert:" + i + "-" + heapArray[i].getValue());
        }
    }

    public void displayArray() {
        System.out.print("heapArray:");
        for (int i = 0; i < maxSize; ++i) {
            System.out.print(heapArray[i].getValue() + " ");
        }
        System.out.println();
    }

    public void display() {
        displayArray();
        System.out.println("========================================");

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        while (currentSize > 0) {
            if (column == 0) {
                for (int i = 0; i < nBlanks; ++i) {
                    System.out.print(" ");
                }
            }
            System.out.print(heapArray[j].getValue());
            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int i =0; i < nBlanks*2-2; ++i) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n========================================");
    }
}
