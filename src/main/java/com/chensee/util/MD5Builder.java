package com.chensee.util;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密
 */
public class MD5Builder {

    /**
     * 用于将字节转化成16进制的字符
     */
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 将文件进行MD5加密
     * @param file   需要加密的文件
     * @return MD5摘要码
     * */
    public static String getMd5(File file) throws IOException, NoSuchAlgorithmException {
        try (FileInputStream fis = new FileInputStream(file)){
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] b = md.digest();
            return byteToHexString(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 将String进行MD5加密
     * @param message   需要加密的String
     * @return MD5信息
     * */
    public static String getMD5(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(message.getBytes("UTF-8"));
            return byteToHexString(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 把byte[]数组转换成十六进制字符串表示形式
     * @param tmp   需要转换的byte
     * @return 16进制字符串表示
     * */
    private static String byteToHexString(byte[] tmp) {
        String s;
        //用字节表示就是16个字节
        char str[] = new char[16 * 2];//每个字节用16进制表示，使用两个字符
        //所以表示成16进制需要32个字符
        int k = 0;//表示转换结果中对应的字符位置
        for(int i = 0; i < 16; i++) {//从第一个字节开始，对应MD5的每一个字节
            //转换成16进制字符的转换
            byte byte0 = tmp[i];//取第i个字节
            str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高4位的数字转换
            // >>> 为逻辑右移，将符号位一起右移
            str[k++] = hexDigits[byte0 & 0xf]; //取字节中低4位的数字转换
        }
        s = new String(str);
        return s;
    }
}
