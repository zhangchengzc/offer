package com.offer.heap;

/**
 * Created by zhangcheng on 2018/3/13.
 */
public class BinaryHeap {
    private HeapNode[] heapArray = null;
    int maxSize;
    int currentSize;

    BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new HeapNode[this.maxSize];
        currentSize = 0;
    }

    public boolean insert(int value) {
        if (currentSize == maxSize)
            return false;

        HeapNode node = new HeapNode(value);
        heapArray[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }

    //向上筛选
    private void trickleUp(int index) {
        HeapNode tmpNode = heapArray[index];
        //得到目标节点父节点的索引值
        int parentIndex = (index - 1)/2;
        while (parentIndex >= 0 && index > 0) {
            //缓存节点的值大于父节点的值，才会进行后续操作，否则直接跳出
            if (tmpNode.getValue() < heapArray[parentIndex].getValue())
                break;

            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1)/2;
        }
        heapArray[index] = tmpNode;
    }

    public HeapNode remove() {
        HeapNode root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    //向下筛选
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
            if (tmpNode.getValue() > heapArray[largeChildIndex].getValue()) {
                break;
            } else {
                heapArray[index] = heapArray[largeChildIndex];
                index = largeChildIndex;
            }
        }
        heapArray[index] = tmpNode;
    }


    public void display() {
        System.out.print("heapArray:");
        for (int i = 0; i < currentSize; ++i) {
            System.out.print(heapArray[i].getValue() + " ");
        }
        System.out.println();
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
