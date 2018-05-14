package com.offer.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhangcheng on 2018/5/14.
 */
public class Number33 {

    @Test
    public void test(){
        printMinNumber(new int[]{1});
    }

    /**
     * 将int数组转化为String数组，利用String来将数组排序
     * @param num
     */
    public void printMinNumber(int[] num){
        if(num == null || num.length == 0)
            return;
        String[] strNum = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strNum[i] = String.valueOf(num[i]);
        }
        printMinNumber(strNum);
    }
    private void printMinNumber(String[] str){
        Arrays.sort(str,new myComparator());
        StringBuilder sl = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sl.append(str[i]);
        }
        System.out.println(sl.toString());
    }

    /**
     * 自定义比较器
     */
    class myComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else if(o1.length() < o2.length())
                return helpCompare(o1,o2);
            else
                return -helpCompare(o2,o1);

        }

        private int helpCompare(String o1,String o2){
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            if(o1.equals(o2.substring(0,o1.length())))
            {
                if(o1.length() == 1)
                    return o1.charAt(0) - o2.charAt(1);
                if(o2.substring(o1.length()).length() < o1.length())
                    return -helpCompare(o2.substring(o1.length()),o1);
                else
                    return helpCompare(o1,o2.substring(o1.length()));
            }else
                return o1.compareTo(o2);
        }
    }
}
