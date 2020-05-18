package com.chensee.serialize;

/**
 * @author ah
 * @title: Test
 * @date 2020/4/3 14:23
 */
public class Test {
    public static void main(String[] args) {
        int ab = FileUtil.countWordInFile("E:\\aaa.txt", "ab");
        System.out.println(ab);
    }
}
