package com.example.delayqueen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaskProducer {

    private static final String DELAY_ZSET_KEY = "delay_zset";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void produce(Integer taskId, long exeTime) {
        System.out.println("加入任务， taskId: " + taskId + ", exeTime: " + exeTime + ", 当前时间：" + System.currentTimeMillis());
        redisTemplate.opsForZSet().add(DELAY_ZSET_KEY, String.valueOf(taskId),exeTime);
    }

}
