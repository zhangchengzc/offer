package com.offer.greed;

/**
 * 假设1元、2元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3, c4, c5, c6张。现在要用这些钱来支付K元，至少要用多少张纸币？
 * 用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。在日常生活中我们自然而然也是这么做的。在程序中已经事先将Value按照从小到大的顺序排好。
 * Created by zhangcheng on 2018/7/31.
 */
public class CoinChange {
    public static void main(String[] args) {
        //人民币面值集合
        int[] values = { 1, 2, 5, 10, 20, 50, 100 };
        //各种面值对应数量集合
        int[] counts = { 3, 1, 2, 1, 1, 3, 5 };
        //求442元人民币需各种面值多少张
        int[] num = change(442, values, counts);
        print(num, values);
    }

    public static int[] change(int money, int[] values, int[] counts) {
        //用来记录需要的各种面值张数
        int[] result = new int[values.length];

        for (int i = values.length - 1; i >= 0; i--) {
            int num = 0;
            //需要最大面值人民币张数
            int c = min(money / values[i], counts[i]);
            //剩下钱数
            money = money - c * values[i];
            //将需要最大面值人民币张数存入数组
            num += c;
            result[i] = num;
        }
        return result;
    }

    /**
     * 返回最小值
     */
    private static int min(int i, int j) {
        return i > j ? j : i;
    }

    private static void print(int[] num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num[i] != 0) {
                System.out.println("需要面额为" + values[i] + "的人民币" + num[i] + "张");
            }
        }
    }
}
