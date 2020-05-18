package com.chensee.aop;

import com.chensee.DesignPatternsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaohang
 * @title: Test
 * @projectName DesignPatterns
 * @date 2019/10/12 16:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesignPatternsApplication.class)
public class Test1 {

    @Autowired
    private BaseService baseService;

    @Test
    public void bbb(){
        System.out.println("单元测试开始");
        String msg;
        try {
            baseService.anoundTest("111",1);
            msg = "成功!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "失败!";
        }
        System.out.println(msg);
        System.out.println("单元测试完成");
    }
}
