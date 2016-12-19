package com.lcc.util;

/**
 * 常量工具类
 * Created by lcc on 2016/12/20.
 */
public class Constants {
    private Constants() {
    }

    /**
     * 常量
     */
    public interface Token {
        public final static String RONCOO = "roncoo";
    }

    /**
     * 状态类型
     */
    public interface Status {
        public final static String ZERO = "0";
        public final static String ONE = "1";
        public final static String TWO = "2";
        public final static String THREE = "3";
    }

    /**
     * 数字类型
     */
    public interface Num {
        public final static int ZERO = 0;
        public final static int ONE = 1;
        public final static int FIVE = 5;
        public final static int TEN = 10;
    }

}
