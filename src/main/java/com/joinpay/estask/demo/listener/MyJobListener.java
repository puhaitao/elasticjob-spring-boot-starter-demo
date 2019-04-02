package com.joinpay.estask.demo.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJobListener implements ElasticJobListener {
    private Logger logger = LoggerFactory.getLogger(MyJobListener.class);
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        logger.info("a job start");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        logger.info("a job complete");
    }
}
