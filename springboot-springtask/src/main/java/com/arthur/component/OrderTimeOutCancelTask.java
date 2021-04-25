package com.arthur.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @title: OrderTimeOutCancelTask
 * @Author ArthurJi
 * @Date: 2021/4/25 13:10
 * @Version 1.0
 */
@Component
public class OrderTimeOutCancelTask {
    private Logger logger = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    @Scheduled(cron = "0 0/1 * * * *")
    private void cancelTimeOutOrder() {
        logger.info("取消订单 实现具体的方法");
    }
}
