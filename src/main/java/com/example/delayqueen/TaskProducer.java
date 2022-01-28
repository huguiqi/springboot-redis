package com.example.delayqueen;

import com.example.delayqueen.common.RedisConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaskProducer {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void produce(Integer taskId, long exeTime) {
        System.out.println("加入任务， taskId: " + taskId + ", exeTime: " + exeTime + ", 当前时间：" + System.currentTimeMillis());
        redisTemplate.opsForZSet().add(RedisConst.DELAY_ZSET_KEY, String.valueOf(taskId),exeTime);
    }

}
