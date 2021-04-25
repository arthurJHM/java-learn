package com.arthur.service;

/**
 * @title: OmsPortalOrderService
 * @Author ArthurJi
 * @Date: 2021/4/25 16:28
 * @Version 1.0
 */

import com.arthur.common.api.CommonResult;
import com.arthur.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
