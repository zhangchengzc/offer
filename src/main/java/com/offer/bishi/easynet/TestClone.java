package com.offer.bishi.easynet;


/**
 * Created by zhangcheng on 2018/8/11.
 */
public class TestClone implements Cloneable {
    String str;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    int a;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClone t1 = new TestClone();
        t1.setStr("123");
        t1.setA(6);
        TestClone t2 = (TestClone) t1.clone();
        t2.setStr("456");
        t2.setA(7);
        System.out.println(t1.getA());
    }
}
