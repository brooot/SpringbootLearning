package com.itcodai.course01.controller;

import com.itcodai.course01.config.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    //    获取单个某个服务的url
    @Value("${url.orderUrl}")
    private String orderUrl;

    @Resource
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/config")
    public String testConfig() {
        logger.info("=====直接从配置获取的订单服务地址为：  {}", orderUrl);
        logger.info("=====从微服务类获取的订单服务地址为：  {}", microServiceUrl.getOrderUrl());
        logger.info("=====从微服务类获取的用户服务地址为：  {}", microServiceUrl.getUserUrl());
        logger.info("=====从微服务类获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());
        return "success";
    }

    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======倪升武的个人博客：{}；倪升武的CSDN博客：{}", str1, str2);

        return "success";
    }
}