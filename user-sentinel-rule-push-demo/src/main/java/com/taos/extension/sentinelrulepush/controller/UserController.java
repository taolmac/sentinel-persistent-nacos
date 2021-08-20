package com.taos.extension.sentinelrulepush.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.taos.extension.sentinelrulepush.common.ExceptionUtil;
import com.taos.extension.sentinelrulepush.utils.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/findOrderByUserId/{id}")
    @SentinelResource(value = "findOrderByUserId",
            blockHandlerClass = ExceptionUtil.class,blockHandler = "handleException",
            fallbackClass = ExceptionUtil.class,fallback = "fallback")
    public R findOrderByUserId(@PathVariable("id") Integer id) {

        //TODO
        return null;
    }

    @SentinelResource(value = "hot")
    @RequestMapping("/hot")
    public String hot(String a,String b){
        return a+b;
    }


    AtomicInteger atomicInteger = new AtomicInteger();

    @RequestMapping("/test2")
    public String test2() {
        atomicInteger.getAndIncrement();
        if (atomicInteger.get() % 2 == 0){
            //模拟异常和异常比率
            int i = 1/0;
        }

        return "========test2()";
    }

}
