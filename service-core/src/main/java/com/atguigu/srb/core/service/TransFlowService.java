package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.bo.TransFlowBO;
import com.atguigu.srb.core.pojo.entity.TransFlow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 交易流水表 服务类
 * </p>
 *
 * @author Helen
 * @since 2021-02-20
 */
public interface TransFlowService extends IService<TransFlow> {

    boolean isSaveTransFlow(String agentBillNo);

    void saveTransFlow(TransFlowBO transFlowBO);

    List<TransFlow> selectByUserId(Long userId);

}
