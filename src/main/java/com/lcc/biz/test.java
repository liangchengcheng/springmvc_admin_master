package com.lcc.biz;

/**
 * Created by lcc on 2016/12/22.
 */
public class test {
    static class Inner {}

    public static void foo() { new Inner(); }

    public void bar() { new Inner(); }

    public static void main(String[] args) {
        new Inner();
    }
}
