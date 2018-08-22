package com.offer.chapter6;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/28.
 */
public class Number43 {
    private int maxValue = 6;

    @Test
    public void test(){
        getEachPercent(5);//递归解法
        getEachPercent2(5);//循环解法
    }

    /**
     * 循环解法
     * 每增加一个骰子，和为n的次数应该等于没有这个骰子时n-1的次数+n-2的次数+n-3的次数。。。+n-6的次数。
     * @param num
     */
    public void getEachPercent2(int num){
        if(num <= 0)
            return;
        int[][] array = new int[2][num*maxValue+1];
        int flag = 0;
        //初始化第一个骰子
        for(int i = 1;i <= maxValue; ++i)
            array[flag][i] = 1;
        for(int i = 2;i <= num; ++i){
            for(int j=0;j < i; ++j)
                array[1-flag][j] = 0;//因为num个骰子不可能出现和为0—(num-1)
            //得到新增的骰子每个和出现次数的数组
            for(int j=i;j <= i*maxValue; ++j){
                array[1-flag][j] = 0;//将和为j上的次数清空
                for(int k = 1; k < j && k <= maxValue; ++k)
                    array[1-flag][j] += array[flag][j-k];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(6,num);
        for (int i = num; i <=num * maxValue ; i++) {
            System.out.println((i)+"出现的概率:"+(Math.round(array[flag][i]/total*10000)/100.0)+"%"+"，出现的次数："+array[flag][i]);
        }
    }
    /**
     * 递归解法（全排列思想）
     * @param num
     */
    public void getEachPercent(int num){
        if(num <= 0)
            return;
        int[] array = new int[(maxValue-1)*num+1];
        int current = num;
        //第一个骰子取值范围1—maxValue
        for (int i = 1; i <= maxValue; i++) {
            getEachPercent(num,current-1,i,array);
        }

        double total = Math.pow(6,num);
        for (int i = 0; i <array.length ; i++) {
            System.out.println((i+num)+"出现的概率:"+(Math.round(array[i]/total*10000)/100.0)+"%"+"，出现的次数："+array[i]);
        }
    }

    /**
     * 全排列思想
     * @param num
     * @param current
     * @param sum
     * @param array
     */
    private void getEachPercent(int num,int current,int sum,int[] array){
        if(current == 0) {
            array[sum - num]++;
            return;
        }
        //剩下n-1个骰子上取值
        for (int i = 1; i <= maxValue; i++) {
            getEachPercent(num,current-1,sum+i,array);
        }
    }
}
