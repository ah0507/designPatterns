package com.chensee.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setId("001");
        user.setName("aHang");
        Class aClass = user.getClass();
        Field getName = aClass.getDeclaredField("name");
        getName.setAccessible(true);
        Object o = getName.get(user);
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            int modifiers = field.getModifiers();
            String s = Modifier.toString(modifiers);
            String type = field.getAnnotatedType().getType().getTypeName();
            Object o1 = field.get(user);
            String name = field.getName();
            System.out.println(s + "---" + "---" + type + "---" + name + "----" + o1);
        }

        Method getId = aClass.getDeclaredMethod("setName",String.class);
        getId.setAccessible(true);
        getId.invoke(user, "com/chensee/reflect");
        System.out.println(user);

        User user1 = (User) aClass.newInstance();
        user1.setId("222");
        user1.setName("gao");
        System.out.println(user1);
    }
}
