package com.lcc.util;

/**
 * Created by lcc on 2016/12/20.
 */
import org.apache.commons.codec.binary.Base64;

/**
 * base64工具
 */
public class Base64Util {

    /**
     * 加密
     */
    public static String encrypt(String key) {
        byte[] ec = Base64.encodeBase64(key.getBytes(), true);
        String ec_result = new String(ec).replaceAll("\r|\n", "");
        return ec_result;
    }

    /**
     * 解密
     */
    public static String decode(String key) {
        byte[] dc = Base64.decodeBase64(key.getBytes());
        String dc_result = new String(dc).replaceAll("\r|\n", "");
        return dc_result;
    }
}
