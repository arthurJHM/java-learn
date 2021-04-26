package com.arthur.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Scheduled(cron = "*/1 * * * * *")
    private void sendMessage() {
        cancelOrderSender.sendMessage(11L, 3000 * 1000);
        logger.info("往死信队列加东西");
    }
}
