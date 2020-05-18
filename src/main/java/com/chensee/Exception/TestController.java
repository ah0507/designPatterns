package com.chensee.Exception;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * spring设置全局异常
 * 测试异常的抛出
 */
@RestController
@RequestMapping("/")
public class TestController {

    /**
     * 测试返回异常信息
     * @return
     */
    @GetMapping("/exception")
    public String returnExceptionInfo() {
        int msg = 1;
        if (msg != 2) {
            // 用户民错误或不存在异常
            throw new BusinessRuntimeException(ResultCode.USERNAME_ERROR);
        }
        return "success";
    }

    /**
     * 测试返回异常信息
     * @return
     */
    @GetMapping("/a")
    public String a() {
        int msg = 1;
        if (msg != 2) {
            // 用户民错误或不存在异常
            throw new BusinessException1("100","msg");
        }
        return "success";
    }

    @PostMapping("/user")
    public String getUser(@RequestBody @Validated User user) {
        List<String> list = new ArrayList<>();
        String s = list.get(0);
        System.out.println(s);
        return "success";
    }

    @GetMapping("/param")
    public String getUser(@RequestParam(value = "name", required = true) String name) {
        System.out.println(111);
        return "success";
    }
}
