package com.demo.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : chenjie
 * @date : 2019-11-08 23:14
 * @describe :
 */
@RestController
public class MyController {
    @Autowired
    private Redisson redisson;

    @GetMapping("/test")
    public String test() {
        RLock lock = redisson.getLock("myProduct");
        lock.lock(30, TimeUnit.SECONDS);
        try {
            //doSomething
        } finally {
            lock.unlock();
        }
        return "操作完成";
    }

}
